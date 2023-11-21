package com.utn.k8.Preenunciado.entidades.pkCompuesta;


import java.io.Serializable;
import java.util.Objects;

public class OrderDetailID implements Serializable {
    private Long orderId;
    private Long productId;

    public OrderDetailID(Long orderId, Long productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailID that = (OrderDetailID) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId);
    }

    // PK Compuesta
    /*@Data
    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public class OrderDetailId implements Serializable {
        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "OrderID")
        private Order order;

        @ManyToOne
        @JoinColumn(name = "ProductID")
        private Product product;
    }*/
}