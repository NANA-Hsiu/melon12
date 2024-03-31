package cn.com.melon12.data.controller;


import cn.com.melon12.data.entity.*;
import cn.com.melon12.data.service.*;
import cn.com.melon12.user.service.IUserTableService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liulongqi
 * @since 2020-07-27
 */
@CrossOrigin
@RestController
@RequestMapping("/data")
public class DataTableController {
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

    @RequestMapping(value="/getprovince", method= RequestMethod.GET)
    public JSONObject getprovince(){
        List<ProvenceTable> myprovince = provenceTableService.getProvince();
        List<JSONObject> myp = new ArrayList<>();
        JSONObject provincejson=new JSONObject();
        int i = myprovince.size();
        for(int j = 0; j < i ; j++ ) {
            provincejson=new JSONObject();
            provincejson.put("name", myprovince.get(j).getProvence());
            myp.add(provincejson);
        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("type", "省份");
        jsonObj1.put("provinces", myp);
        return jsonObj1;
    }

    @RequestMapping(value="/getmarket", method= RequestMethod.GET)
    public JSONObject getmarket(String province){
        Integer province_id = provenceTableService.getProvinceId(province);
        List<MarketTable> mymarket = marketTableService.getMarket(province_id);
        List<JSONObject> mym = new ArrayList<>();
        JSONObject marketjson=new JSONObject();
        int i = mymarket.size();
        for(int j = 0; j < i ; j++ ) {
          marketjson=new JSONObject();
            marketjson.put("name", mymarket.get(j).getMarket());
            mym.add(marketjson);

        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("type", "市场");
        jsonObj1.put("markets", mym);
        return jsonObj1;
    }

    @RequestMapping(value="/gettype", method= RequestMethod.GET)
    public JSONObject gettype(String province,String market){
        Integer province_id = provenceTableService.getProvinceId(province);
        Integer market_id = marketTableService.getMarketId(market,province_id);
        List<TypeTable> mytype = typeTableService.getType(market_id);
        List<JSONObject> mym = new ArrayList<JSONObject>();
        JSONObject typejson=new JSONObject();
        int i = mytype.size();
        for(int j = 0; j < i ; j++ ) {
            typejson=new JSONObject();
            typejson.put("name",mytype.get(j).getType());

            mym.add(typejson);
        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("type", "种类");
        jsonObj1.put("types", mym);
        return jsonObj1;
    }

    @RequestMapping(value="/getvariety", method= RequestMethod.GET)
    public JSONObject getvariety(String province,String market, String type){
        Integer province_id = provenceTableService.getProvinceId(province);
        Integer market_id = marketTableService.getMarketId(market,province_id);
        Integer varieties_id = typeTableService.getTypeId(type,market_id);
        List<VarietyTable> myvariety = varietyTableService.getVariety(varieties_id);
        List<JSONObject> mym = new ArrayList<JSONObject>();
        JSONObject varietyJson=new JSONObject();
        int i = myvariety.size();
        for(int j = 0; j < i ; j++ ) {
            varietyJson=new JSONObject();
            varietyJson.put("name",myvariety.get(j).getVariety());
            mym.add(varietyJson);
        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("type", "品种");
        jsonObj1.put("varieties", mym);
        return jsonObj1;
    }
    @RequestMapping(value="/getRegionType",method=RequestMethod.GET)
    public JSONObject getRegionType(){
//        List<TypeTable> myType = typeTableService.getType();
//        List<JSONObject> myt = new ArrayList<>();
//        JSONObject typejson=new JSONObject();
//        int i = myType.size();
//        for(int j = 0; j < i ; j++ ) {
//            typejson=new JSONObject();
//            typejson.put("name", myType.get(j).getType());
//            myt.add(typejson);
//        }
//        JSONObject jsonObj1 = new JSONObject();
//        jsonObj1.put("type", "产品种类");
//        jsonObj1.put("types",myt);
//        return jsonObj1;
        JSONObject jsonObject=new JSONObject();
        jsonObject=baseDataTableService.getReType();
        return  jsonObject;

    }
    @RequestMapping(value="/getRegionVariety",method=RequestMethod.GET)
    public JSONObject getRegionVariety(String type){
        //根据type获得variety
//        Integer varieties_id = typeTableService.getTypeId(type);
//        List<VarietyTable> myvariety = varietyTableService.getVariety(varieties_id);
//        List<JSONObject> mym = new ArrayList<JSONObject>();
//        JSONObject varietyJson=new JSONObject();
//        int i = myvariety.size();
//        for(int j = 0; j < i ; j++ ) {
//            varietyJson=new JSONObject();
//            varietyJson.put("name",myvariety.get(j).getVariety());
//            mym.add(varietyJson);
//        }
//        JSONObject jsonObj1 = new JSONObject();
//        jsonObj1.put("type", "品种");
//        jsonObj1.put("varieties", mym);
//        return jsonObj1;
        JSONObject jsonObject=new JSONObject();
        jsonObject=baseDataTableService.getReVari(type);
        return  jsonObject;
    }

    @RequestMapping(value="/data_query", method= RequestMethod.GET)
    public JSONObject data_query(String province, String market, String varieties, String breed){
        Integer province_id = provenceTableService.getProvinceId(province);
        Integer market_id = marketTableService.getMarketId(market,province_id);
        Integer varieties_id = typeTableService.getTypeId(varieties,market_id);
        Integer breed_id = varietyTableService.getVarietyId(breed,varieties_id);
        List<String> myDateList = new ArrayList<String>();
        List<Double> mySalesList = new ArrayList<Double>();
        List<Double> myPriceList = new ArrayList<Double>();
        List<DataTable> myDataTableList = dataTableService.getDataTable(breed_id);
        int i = myDataTableList.size();
        for(int j = 0; j < i ; j++){
            myDateList.add(myDataTableList.get(j).getDate());
            mySalesList.add(myDataTableList.get(j).getSales());
            myPriceList.add(myDataTableList.get(j).getAve());
        }
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("name", breed);
        jsonObj1.put("date",myDateList);
        jsonObj1.put("amount",mySalesList);
        jsonObj1.put("value",myPriceList);
        List<JSONObject> jsonlist1 = new ArrayList<JSONObject>();
        jsonlist1.add(jsonObj1);

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("name",varieties);
        jsonObj2.put("breed",jsonlist1);
        List<JSONObject> jsonlist2 = new ArrayList<JSONObject>();
        jsonlist2.add(jsonObj2);

        JSONObject jsonObj3 = new JSONObject();
        jsonObj3.put("name",market);
        jsonObj3.put("type",jsonlist2);
        List<JSONObject> jsonlist3 = new ArrayList<JSONObject>();
        jsonlist3.add(jsonObj3);

        JSONObject jsonObj4 = new JSONObject();
        jsonObj4.put("province",province);
        jsonObj4.put("market",jsonlist3);
        List<JSONObject> jsonlist4 = new ArrayList<JSONObject>();
        jsonlist4.add(jsonObj4);

        return jsonObj4;
    }

    @RequestMapping(value="/fetch_query", method= RequestMethod.GET)
    public JSONObject fetch_query(String province, String market, String varieties){
        Integer province_id = provenceTableService.getProvinceId(province);
        Integer market_id = marketTableService.getMarketId(market,province_id);
        Integer varieties_id = typeTableService.getTypeId(varieties,market_id);

        List<FetchTable> myDataTableList = fetchTableService.getFetch(varieties_id);
        List<String> myDateList = new ArrayList<String>();
        List<Integer> myFetchList = new ArrayList<Integer>();
        Integer total1 = 0;
        int i = myDataTableList.size();
        for(int j = 0; j < i ; j++){
            myDateList.add(myDataTableList.get(j).getDate());
            myFetchList.add(myDataTableList.get(j).getFetch());
            total1 += myDataTableList.get(j).getFetch();
        }

        List<FetchTable> AllDataTableList = fetchTableService.getAllFetch();
        Integer total2 = 0;
        int x = AllDataTableList.size();
        for(int j = 0; j < x ; j++){
            total2 += AllDataTableList.get(j).getFetch();
        }
        List<JSONObject> jsonlist0 = new ArrayList<JSONObject>();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("value",total1);
        jsonObj.put("name",varieties);
        JSONObject jsonObj0 = new JSONObject();
        jsonObj0.put("value",total2-total1);
        jsonObj0.put("name","其他");
        jsonlist0.add(jsonObj);
        jsonlist0.add(jsonObj0);

        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("name", varieties);
        jsonObj1.put("fetch_data1",jsonlist0);
        jsonObj1.put("fetch_date",myDateList);
        jsonObj1.put("fetch_amount1",myFetchList);
        List<JSONObject> jsonlist1 = new ArrayList<JSONObject>();
        jsonlist1.add(jsonObj1);

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("name",market);
        jsonObj2.put("type",jsonlist1);
        List<JSONObject> jsonlist2 = new ArrayList<JSONObject>();
        jsonlist2.add(jsonObj2);

        JSONObject jsonObj3 = new JSONObject();
        jsonObj3.put("province",province);
        jsonObj3.put("market",jsonlist2);
        List<JSONObject> jsonlist3 = new ArrayList<JSONObject>();
        jsonlist3.add(jsonObj3);

        JSONObject jsonObj4 = new JSONObject();
        jsonObj4.put( "fetch_query",jsonlist3);
        return jsonObj4;
    }

    @RequestMapping(value="/price_trend", method= RequestMethod.GET)
    public JSONObject price_trend(String date,String province, String market, String varieties, String breed){
        Integer province_id = provenceTableService.getProvinceId(province);
        Integer market_id = marketTableService.getMarketId(market,province_id);
        Integer varieties_id = typeTableService.getTypeId(varieties,market_id);
        Integer breed_id = varietyTableService.getVarietyId(breed,varieties_id);
        List<DataTable> myDataTableList = dataTableService.getDataTable(breed_id,date);
        List<Double> myMaxList = new ArrayList<Double>();
        List<Double> myMinList = new ArrayList<Double>();
        List<Double> myAvesList = new ArrayList<Double>();

        int i = myDataTableList.size();

        System.out.println(i);
        for(int j = 0; j < i ; j++){
            myMaxList.add(myDataTableList.get(j).getMax());
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
            System.out.println(myDataTableList.get(j).getMax());
            myMinList.add(myDataTableList.get(j).getMin());
            myAvesList.add(myDataTableList.get(j).getAve());
        }
        System.out.println("最小价格数组"+myMinList);
        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("date", date);
        jsonObj1.put("min_price",myMinList);
        jsonObj1.put("max_price",myMaxList);
        jsonObj1.put("average_price",myAvesList);
        List<JSONObject> jsonlist1 = new ArrayList<JSONObject>();
        jsonlist1.add(jsonObj1);

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("name",breed);
        jsonObj2.put("dates",jsonlist1);
        List<JSONObject> jsonlist2 = new ArrayList<JSONObject>();
        jsonlist2.add(jsonObj2);

        JSONObject jsonObj3 = new JSONObject();
        jsonObj3.put("price_trend",jsonlist2);
        List<JSONObject> jsonlist3 = new ArrayList<JSONObject>();
        jsonlist3.add(jsonObj3);
        return jsonObj3;
    }


    @RequestMapping(value="/regional_market", method= RequestMethod.GET)
    public JSONObject regional_market(String variety){
        List<PriceTable> regionallist = priceTableService.getProvinceId(variety);

        JSONObject regionJson=new JSONObject();
        List<JSONObject> regionObj =new ArrayList<>();
        JSONObject jsonList=new JSONObject();

        int i=regionallist.size();
        for(int j=0;j<i;j++){
            regionJson=new JSONObject();
            Integer provinceid=regionallist.get(j).getIdProvence();
            regionJson.put("name",provenceTableService.getProvince(provinceid));
            //  List<PriceTable> priceTableList=priceTableService.getPrice(variety);
            //   int m=priceTableList.size();
            //   for(int n=0;n<m;n++){

            regionJson.put("value",priceTableService.getPrice(variety,provinceid));
            //   }
            regionObj.add(regionJson);
        }

        jsonList.put("regional_market",regionObj);
        return  jsonList;
    }
    @RequestMapping(value="/varieties_contrast", method= RequestMethod.GET)
    public JSONObject varieties_contrast(String province,String market,String type){
        Integer province_id = provenceTableService.getProvinceId(province);
        Integer market_id = marketTableService.getMarketId(market,province_id);
        Integer type_id = typeTableService.getTypeId(type,market_id);
        //List<DataTable> myDataTableList = dataTableService.getDataTable(type_id);
        List<VarietyTable> varlist = varietyTableService.getVariety(type_id);

        List<Double> pricelist = new ArrayList<Double>();
        List<String> timelist = new ArrayList<String>();

        int a = varlist.size();
        JSONObject jsonObj1 = new JSONObject();
        List<JSONObject> jsonlist1 = new ArrayList<JSONObject>();
        List<List> whole_data = new ArrayList<List>();
        for(int b = 0;b<a;b++)
        {
            List<DataTable>myDataTableList = dataTableService.getDataTable(varlist.get(b).getId());
            jsonObj1 = new JSONObject();
            Integer name = varlist.get(b).getId();
            String namen=varietyTableService.getVarietys(name);
            int i = myDataTableList.size();

            for(int j = 0;j<i;j++)
            {
                if(b==0)
                {
                    timelist.add(myDataTableList.get(j).getDate());
                }
                pricelist.add(myDataTableList.get(j).getAve());
            }
            jsonObj1.put("name", namen);
            jsonObj1.put("type","line");
            jsonObj1.put("data",pricelist);
            jsonlist1.add(jsonObj1);
            myDataTableList.clear();
            pricelist.clear();
        }

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("name",type);
        jsonObj2.put("variety_date",timelist);
        jsonObj2.put("datasets",jsonlist1);
        List<JSONObject> jsonlist2 = new ArrayList<JSONObject>();
        jsonlist2.add(jsonObj2);

        JSONObject jsonObj3 = new JSONObject();
        jsonObj3.put("name",market);
        jsonObj3.put("type",jsonlist2);
        List<JSONObject> jsonlist3 = new ArrayList<JSONObject>();
        jsonlist3.add(jsonObj3);

        JSONObject jsonObj4 = new JSONObject();
        jsonObj4.put("province",province);
        jsonObj4.put("market",jsonlist3);
        List<JSONObject> jsonlist4 = new ArrayList<JSONObject>();
        jsonlist4.add(jsonObj4);

        JSONObject jsonObj5 = new JSONObject();
        jsonObj5.put("varieties_contrast",jsonlist4);
        return jsonObj5;
    }
    @RequestMapping(value="/real_time_monitoring", method= RequestMethod.GET)
    public JSONObject real_time_monitoring()throws ParseException {
        Integer market_amount = marketTableService.getMarket_amount();
        Integer type_amount = typeTableService.getType_amount();
        Integer breed_amount = varietyTableService.getVariety_amount();
        Integer fetch_total = fetchTableService.getFetch_Total();

        Calendar cal=Calendar.getInstance();

        int y=cal.get(Calendar.YEAR);

        int m=cal.get(Calendar.MONTH);

        int d=cal.get(Calendar.DATE);

        int h=cal.get(Calendar.HOUR_OF_DAY);

        int mi=cal.get(Calendar.MINUTE);

        int s=cal.get(Calendar.SECOND);

        String mm,dd;
        if(m<10)
        {
            mm = "0"+m;
        }
        else
        {
            mm = ""+m;
        }

        if(d<10)
        {
            dd = "0"+d;
        }
        else
        {
            dd = ""+d;
        }
        String date = y+"-"+mm+"-"+"dd";
        String date2 = y+"年"+mm+"月"+dd+"日"+h+"时"+mi+"分"+s+"秒";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

        Integer fetch_today = fetchTableService.getFetch_Today();

        JSONObject jsonObj1 = new JSONObject();
        jsonObj1.put("market_amount", market_amount);
        jsonObj1.put("type_amount",type_amount);
        jsonObj1.put("breed_amount",breed_amount);
        jsonObj1.put("fetch_total", fetch_total);
        jsonObj1.put("fetch_today",fetch_today);
        jsonObj1.put("fetch_time",date2);

        JSONObject jsonObj2 = new JSONObject();
        jsonObj2.put("real_time_monitoring",jsonObj1);

        return jsonObj2;
    }
}
