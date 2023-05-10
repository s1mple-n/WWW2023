package n16.hb_n16.services;

import n16.hb_n16.entity.CartDetail;
import n16.hb_n16.entity.CartHeader;

import java.util.List;

public interface CartHeaderService {
    List<CartHeader> getAllCartHeader();
    CartHeader getCartHeaderByID(int cartHeaderID);
    void addOrUpdateCartHeader(CartHeader cartHeader);
    void updateCartTotalPriceAndQuantity(int userID, List<CartDetail> cartDetails);
}
