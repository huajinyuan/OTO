package cn.gtgs.base.OTO.activity.orders.presenter;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.request.GetRequest;

import java.util.ArrayList;

import cn.gtgs.base.OTO.activity.orders.model.NewOrderData;
import cn.gtgs.base.OTO.activity.orders.model.OrderData;
import cn.gtgs.base.OTO.activity.orders.model.OrderToNewOrder;
import cn.gtgs.base.OTO.activity.orders.view.OrderDelegate;
import cn.gtgs.base.OTO.http.Config;
import cn.gtgs.base.OTO.http.HttpMethods;
import cn.gtgs.base.OTO.utils.Parsing;
import okhttp3.Response;
import rx.Subscriber;

/**
 * Created by gtgs on 2017/2/10.
 */

public class OrderPresenter implements IOrderPresenter {
//    private ArrayList<OrderData> dataList = new ArrayList<>();
    //模拟的数据源
//    private String datas = "[{\"title\":\"iphone\",\"content\":[{\"order\":\"iphone7 128G 深空灰\",\"price\":\"6388\",\"image\":\"https://img.alicdn.com/imgextra/i1/TB1AsbTOXXXXXcwXFXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg\"},{\"order\":\"iPhone6s 64G 深空灰\",\"price\":\"4688\",\"image\":\"https://img.alicdn.com/bao/uploaded/i1/TB1Vrz8NXXXXXbkXVXXO6i5.VXX_112353.jpg_430x430q90.jpg\"}]},{\"title\":\"小米\",\"content\":[{\"order\":\"小米5s 32G 黑色\",\"price\":\"1599\",\"image\":\"https://img.alicdn.com/imgextra/i2/1714128138/TB2tEZKbY1K.eBjSszbXXcTHpXa_!!1714128138.jpg_430x430q90.jpg\"},{\"order\":\"红米4A 香槟金 16G\",\"price\":\"499\",\"image\":\"https://img.alicdn.com/bao/uploaded/i8/TB1_hyeOXXXXXc5XpXX9Bbz_FXX_062236.jpg_430x430q90.jpg\"}]},{\"title\":\"华为\",\"content\":[{\"order\":\"华为mate9 32G 土豪金\",\"price\":\"3688\",\"image\":\"https://img.alicdn.com/bao/uploaded/i5/TB1okEUNVXXXXb8apXXqo60.pXX_103952.jpg_430x430q90.jpg\"},{\"order\":\"华为荣耀7 32G 白色\",\"price\":\"1699\",\"image\":\"https://img.alicdn.com/imgextra/i4/304539683/TB2OecPiVXXXXc2XpXXXXXXXXXX_!!304539683.png_430x430q90.jpg\"}]},{\"title\":\"魅族\",\"content\":[{\"order\":\"魅族Pro6  32G 深空灰 \",\"price\":\"1999\",\"image\":\"https://img.alicdn.com/imgextra/i1/1695308781/TB2j_E0chuI.eBjy0FdXXXgbVXa_!!1695308781.jpg_430x430q90.jpg\"}]},{\"title\":\"VIVO\",\"content\":[{\"order\":\"vivo X9前置双摄全网通4G美颜自拍超薄智能手机大屏vivox9\",\"price\":\"2798.00\",\"image\":\"https://img.alicdn.com/imgextra/i1/883737303/TB2G2FddFOP.eBjSZFHXXXQnpXa_!!883737303.jpg_430x430q90.jpg\"},{\"order\":\"vivo Y51A高配版全网通 超薄5英寸大屏双卡双待4G智能手机vivoy51\",\"price\":\"1098.01\",\"image\":\"https://img.alicdn.com/imgextra/i2/883737303/TB2NqkgXFHzQeBjSZFOXXcM9FXa_!!883737303.jpg_430x430q90.jpg\"},{\"order\":\"vivo X7全网通4G自拍美颜拍照智能手机指纹超薄大屏双卡vivox7\",\"price\":\"2498.00\",\"image\":\"https://img.alicdn.com/imgextra/i2/883737303/TB2LrogXKrAQeBjSZFwXXa_RpXa_!!883737303.jpg_430x430q90.jpg\"}]}]";
//    private ArrayList<NewOrderData> list = new ArrayList<>();

    @Override
    public void initData(OrderDelegate delegate) {
//        dataList.addAll(JSON.parseArray(datas, OrderData.class));
//        //对数据源进行拆分 这里的NewDate里面的
//        // 1 表示是商品的头部标题
//        // 2 表示是商品的item的布局
//        // 3 表示的是底部的item的布局
//        for (int i = 0; i < dataList.size(); i++) {
//            list.add(new NewOrderData(1, dataList.get(i).getTitle(), "", "", ""));
//            for (int j = 0; j < dataList.get(i).getContent().size(); j++) {
//                NewOrderData newDate = new NewOrderData("", dataList.get(i).getContent().get(0).getOrder(), dataList.get(i).getContent().get(j).getPrice(), dataList.get(i).getContent().get(j).getImage());
//                if (j == 0) {
//                    newDate.setType(4);
//                } else {
//                    newDate.setType(8);
//                }
//
//                list.add(newDate);
//            }
//            list.add(new NewDate(2, "", "", "", ""));
//        }
//        delegate.setData(list);
        getOrderList(delegate);

    }

    private void getOrderList(final OrderDelegate delegate) {
        HttpParams params = HttpMethods.getInstance().getHttpParams();
        GetRequest request = OkGo.get(Config.ORDER_URL).params(params);
        HttpMethods.getInstance().doGet(request, true).subscribe(new Subscriber<Response>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response response) {
                ArrayList<OrderData> dataList = new ArrayList<OrderData>();
                if (Parsing.getInstance().checkNotError(response)) {
                    dataList = Parsing.getInstance().ResponseToList(response, OrderData.class);
                    if (null != dataList && !dataList.isEmpty()) {
                        ArrayList<NewOrderData> list = OrderToNewOrder.getInstance().OrderListTNew(dataList);
                        delegate.setData(list);
                        return;
                    }
                }
                delegate.setData(null);
            }
        });

    }

}
