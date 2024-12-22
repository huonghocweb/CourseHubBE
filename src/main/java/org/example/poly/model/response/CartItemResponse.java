package org.example.poly.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.poly.model.entity.Cart;
import org.example.poly.model.entity.Course;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private Integer cartItemId;
    private Integer quantity;
    private Double price;
    private CourseResponse course;
}
