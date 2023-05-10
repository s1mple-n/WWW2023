package n16.hb_n16.impl;

import n16.hb_n16.entity.CartDetail;
import n16.hb_n16.repository.CartDetailRepository;
import n16.hb_n16.services.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @Override
    public List<CartDetail> getAllCartDetail() {
        return cartDetailRepository.findAll();
    }

    @Override
    public List<CartDetail> getCartDetailByCartHeaderID(int cartID) {
        return cartDetailRepository.getCartDetailsByCartHeaderID(cartID);
    }

    @Override
    public List<CartDetail> getCartDetailByBagID(int bagID) {
        return cartDetailRepository.getCartDetailsByBagID(bagID);
    }

    @Override
    public CartDetail getCartDetailByCartHeaderIdAndBagId(int cartID, int bagID) {
        return cartDetailRepository.getCartDetailByCartHeaderIdAndBagId(cartID,bagID);
    }

    @Override
    public void addOrUpdateCartDetail(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
    }

    @Override
    public void deleteCartDetailByCartHeaderId(int cartID) {
        cartDetailRepository.deleteCartDetailByCartHeaderId(cartID);
    }

    @Override
    public void deleteCartDetailByCartHeaderIdAndBagId(int cartID, int bagID) {
        cartDetailRepository.deleteCartDetailByCartHeaderIdAndBagId(cartID,bagID);
    }
}
