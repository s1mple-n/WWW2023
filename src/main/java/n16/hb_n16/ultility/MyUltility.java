package n16.hb_n16.ultility;

import n16.hb_n16.entity.SaleOrder;
import n16.hb_n16.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MyUltility {
    public static List<Integer> getOrderStatus(List<SaleOrder> saleOrders) {

        List<Integer> orderStatus = new ArrayList<>();

        orderStatus.add(0);
        orderStatus.add(0);
        orderStatus.add(0);
        orderStatus.add(0);

        saleOrders.forEach(saleOrder -> {
            int index = saleOrder.getStatus() - 1;
            orderStatus.set(index, orderStatus.get(index) + 1);
        });

        return orderStatus;
    }

    public static List<Integer> getUserGenderAmount(List<User> users) {

        List<Integer> userGenderAmount = new ArrayList<>();

        userGenderAmount.add(0);
        userGenderAmount.add(0);
        userGenderAmount.add(0);

        users.forEach(user -> {
            if (user.getGender().equalsIgnoreCase("nam"))
                userGenderAmount.set(1, userGenderAmount.get(1) + 1);
            else
                userGenderAmount.set(2, userGenderAmount.get(2) + 1);
        });

        userGenderAmount.set(0, users.size());

        return userGenderAmount;
    }
}
