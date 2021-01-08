import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import com.octo.dto.criteria.SearchCriteriaDTO;
import com.octo.dto.Video;

public class VideoSpecification implements Specification<Video> {


    private SearchCriteriaDTO criteria;

    public VideoSpecification(final SearchCriteriaDTO cr) {
        this.criteria =cr;
    }


    @Override
    public Predicate toPredicate
      (Root<Video> root, CriteriaQuery<Video> query, CriteriaBuilder builder) {

          String[] tags = this.criteria.getTags().split(",");

 
        if (this.criteria.getLevel() == null && tags.length() === 0) {
              return query.select(root);
        }

        else if (this.criteria.getLevel() && tags.length() != 0) {

            return query.select(root)
            .where(builder.equal(root.get("level"), this.criteria.getLevel()))

        } 
        else if (this.criteria.getLevel() && tags.length() === 0) {
            return query.select(root)
            .where(builder.equal(root.get("level"), this.criteria.getLevel()))
        } 
        else if (this.criteria.getLevel() == null && tags.length() != 0) {
            return query.select(root)
             .where(builder.equal(root.get("tags")).in(tags))
        }
        return null;
    }
}