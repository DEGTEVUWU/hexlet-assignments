package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

import java.time.LocalDate;

// BEGIN
@Component // Для возможности автоматической инъекции
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO params) {
        return withCategoryId(params.getCategoryId())
                .and(withPriceGt(params.getPriceGt()))
                .and(withPriceLt(params.getPriceLt()))
                .and(withRatingGt(params.getRatingGt()))
                .and(withTitleCount(params.getTitleCont()));

    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null ?
                cb.conjunction() :
                cb.equal(root.get("category").get("id"), categoryId);
    }


    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, cb) -> priceGt == null ?
                cb.conjunction() :
                cb.greaterThan(root.get("price"), priceGt);
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, cb) -> priceLt == null ?
                cb.conjunction() :
                cb.lessThan(root.get("price"), priceLt);
    }

    private Specification<Product> withRatingGt(Double ratingGt) {
        return (root, query, cb) -> ratingGt == null ?
                cb.conjunction() :
                cb.greaterThan(root.get("rating"), ratingGt);
    }
    private Specification<Product> withTitleCount(String titleCount) {
        return (root, query, cb) -> titleCount == null ?
                cb.conjunction() :
                cb.like(cb.lower(root.get("title")), "%" + titleCount.toLowerCase() + "%");
    }

}
// END
