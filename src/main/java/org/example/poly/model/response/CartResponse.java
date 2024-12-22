package org.example.poly.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.poly.model.entity.CartItem;
import org.example.poly.model.entity.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private Integer cartId;
    private Double totalPrice;
    private Integer totalQuantity;
    private UserResponse user;
    private List<CartItemResponse> cartItems;
}
