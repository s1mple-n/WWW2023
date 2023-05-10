package n16.hb_n16.impl;

import n16.hb_n16.entity.CartDetail;
import n16.hb_n16.entity.CartHeader;
import n16.hb_n16.repository.CartHeaderRepository;
import n16.hb_n16.services.CartHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CartHeaderServiceImpl implements CartHeaderService {
    @Autowired
    private CartHeaderRepository cartHeaderRepository;

    @Override
    public List<CartHeader> getAllCartHeader() {
        return cartHeaderRepository.findAll();
    }

    @Override
    public CartHeader getCartHeaderByID(int cartHeaderID) {
        Optional<CartHeader> result = cartHeaderRepository.findById(cartHeaderID);
        CartHeader cartHeader = null;
        if (result.isPresent()){
            cartHeader = result.get();
        }
        else {
            throw new RuntimeException("Can not find cart header id - "+ cartHeaderID);
        }
        return cartHeader;
    }

    @Override
    public void addOrUpdateCartHeader(CartHeader cartHeader) {
        cartHeaderRepository.save(cartHeader);
    }

    @Override
    public void updateCartTotalPriceAndQuantity(int userID, List<CartDetail> cartDetails) {
        CartHeader cartHeader = getCartHeaderByID(userID);
        int totalQuantity = 0;
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartDetail cartDetail: cartDetails){
            totalPrice = totalPrice.add(cartDetail.getBag().getPrice().multiply(new BigDecimal(cartDetail.getBagQty())));
            totalQuantity += cartDetail.getBagQty();
        }
        cartHeader.setTotalPrice(totalPrice);
        cartHeader.setTotalQuantity(totalQuantity);
        addOrUpdateCartHeader(cartHeader);
    }
}
