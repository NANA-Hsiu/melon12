package cn.com.melon12.data.controller;


import cn.com.melon12.data.entity.*;
import cn.com.melon12.data.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-30
 */
@CrossOrigin
@RestController
@RequestMapping("/data")
public class BasedataTableController {
    @Autowired
    private IBasedataTableService baseDataTableService;
    @Autowired
    private IDataTableService dataTableService;
    @Autowired
    private IFetchTableService fetchTableService;
    @Autowired
    private IPriceTableService priceTableService;
    @Autowired
    private IProvenceTableService provenceTableService;
    @Autowired
    private IMarketTableService marketTableService;
    @Autowired
    private ITypeTableService typeTableService;
    @Autowired
    private IVarietyTableService varietyTableService;

    @RequestMapping(value="/updateData", method= RequestMethod.GET)
    public JSONObject updateData(){
        List<BasedataTable> mybasedata = baseDataTableService.list();
        int size = mybasedata.size();
        List<ProvenceTable> allprovincetable = new ArrayList<ProvenceTable>();
        for(int j = 0; j < size; j++)
        {
            ProvenceTable myprovence = new ProvenceTable();
            myprovence.setProvence(mybasedata.get(j).getProvince());
            allprovincetable.add(myprovence);
        }

        provenceTableService.addProvince(allprovincetable);

        List<MarketTable> allmarkettable = new ArrayList<MarketTable>();
        for(int j = 0; j < size; j++)
        {
            MarketTable myMarket = new MarketTable();
            myMarket.setMarket(mybasedata.get(j).getMarket());
            myMarket.setIdProvence(provenceTableService.getProvinceId(mybasedata.get(j).getProvince()));
            allmarkettable.add(myMarket);
        }
        marketTableService.addMarket(allmarkettable);


        List<TypeTable> alltypetable = new ArrayList<TypeTable>();
        for(int j = 0; j < size; j++)
        {
            TypeTable myType = new TypeTable();
            myType.setType(mybasedata.get(j).getType());
            myType.setIdMarket(marketTableService.getMarketId(mybasedata.get(j).getMarket(),provenceTableService.getProvinceId(mybasedata.get(j).getProvince())));
            alltypetable.add(myType);
        }
        typeTableService.addType(alltypetable);

        List<VarietyTable> allvarietytable = new ArrayList<VarietyTable>();
        for(int j = 0; j < size; j++)
        {
            VarietyTable myVariety = new VarietyTable();
            myVariety.setVariety(mybasedata.get(j).getVariety());
            myVariety.setIdType(typeTableService.getTypeId(mybasedata.get(j).getType(),marketTableService.getMarketId(mybasedata.get(j).getMarket(),provenceTableService.getProvinceId(mybasedata.get(j).getProvince()))));
            allvarietytable.add(myVariety);
        }
        varietyTableService.addVariety(allvarietytable);


        List<DataTable> alldatatable = new ArrayList<DataTable>();
        for(int j = 0; j < size; j++)
        {
            DataTable mydatatable = new DataTable();
            mydatatable.setDate(mybasedata.get(j).getDate());
            mydatatable.setMin(mybasedata.get(j).getMinPrice());
            mydatatable.setMax(mybasedata.get(j).getMaxPrice());
            mydatatable.setAve(mybasedata.get(j).getAvePrice());
            mydatatable.setIdVariety(varietyTableService.getVarietyId(mybasedata.get(j).getVariety(),typeTableService.getTypeId(mybasedata.get(j).getType(),marketTableService.getMarketId(mybasedata.get(j).getMarket(),provenceTableService.getProvinceId(mybasedata.get(j).getProvince())))));
            Random r = new Random();
            mydatatable.setSales(r.nextInt(100000) * 0.01 + 1000);
            alldatatable.add(mydatatable);
        }
        dataTableService.addData(alldatatable);

        List<FetchTable> allfetchtable = new ArrayList<FetchTable>();
        for(int j = 0; j < size; j++){
            FetchTable myFetchtable = new FetchTable();
            myFetchtable.setDate(mybasedata.get(j).getDate());
            Random r = new Random();
            myFetchtable.setFetches(r.nextInt(500)+300);
            myFetchtable.setIdType(typeTableService.getTypeId(mybasedata.get(j).getType(),marketTableService.getMarketId(mybasedata.get(j).getMarket(),provenceTableService.getProvinceId(mybasedata.get(j).getProvince()))));
            allfetchtable.add(myFetchtable);
        }
        fetchTableService.addFetch(allfetchtable);

        List<PriceTable> allpricetable = new ArrayList<PriceTable>();
        for(int j = 0 ; j < size; j++){
            PriceTable myPricetable = new PriceTable();
            myPricetable.setIdProvence(provenceTableService.getProvinceId(mybasedata.get(j).getProvince()));
            myPricetable.setType(mybasedata.get(j).getVariety());
            myPricetable.setPrice(mybasedata.get(j).getAvePrice());
            allpricetable.add(myPricetable);
        }
        priceTableService.addPrice(allpricetable);

        return null;
    }


    @RequestMapping(value="/selectByType", method= RequestMethod.POST)
    public JSONObject selectByType(String type,Integer page_num){
        JSONObject jsonObj = new JSONObject();
        System.out.println(type);
        System.out.println(page_num);
        try {
            IPage<BasedataTable> basedataIPage=baseDataTableService.getBasedataList(type,page_num);
            jsonObj.put("errcode", "0");
            jsonObj.put("data", basedataIPage);
        }catch(NullPointerException poex){
            jsonObj.put("errcode", "20001");
            jsonObj.put("errmsg", "请求错误");
            poex.printStackTrace();
        }
        return jsonObj;
    }


}
