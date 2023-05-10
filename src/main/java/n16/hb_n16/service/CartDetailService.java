package n16.hb_n16.service;

import n16.hb_n16.entity.CartDetail;

import java.util.List;

public interface CartDetailService {
    List<CartDetail> getAllCartDetail();
    List<CartDetail> getCartDetailByCartHeaderID(int cartID);
    List<CartDetail> getCartDetailByBagID(int bagID);
    CartDetail getCartDetailByCartHeaderIdAndBagId(int cartID, int bagID);
    void addOrUpdateCartDetail(CartDetail cartDetail);
    void deleteCartDetailByCartHeaderId(int cartID);
    void deleteCartDetailByCartHeaderIdAndBagId(int cartID,int bagID);

}
