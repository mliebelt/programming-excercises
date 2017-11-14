package com.goeckeler.excercises.festival.model.domain;

import static org.assertj.core.api.Assertions.*;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.collection.SortedSet;
import io.vavr.collection.TreeSet;
import org.junit.Test;

public class DomainModelTest {

    /**
     * A meaningful string description does not only help to debug the code, it also helps to implement
     * the most common domain methods
     */
    @Test
    public void should_provide_toString() {
        assertThat(new Act("Adele").toString()).isNotBlank().isEqualToIgnoringCase("adele");
        assertThat(new Act(null).toString()).isNotNull();
    }

    @Test
    public void should_implement_equals() {
        Act adele1 = new Act("Adele");
        Act adele2 = new Act("Adele");
        Act cher = new Act("Cher");

        Set<Act> artists = HashSet.of(adele1, adele2, cher);

        assertThat(artists).hasSize(2).containsOnly(adele1, cher);
    }

    @Test
    public void should_implement_hashCode() {
        Act adele1 = new Act("Adele");
        Act adele2 = new Act("Adele");
        Act cher = new Act("Cher");
        Act empty = new Act(null);

        assertThat(adele1.hashCode()).isEqualTo(adele2.hashCode());
        assertThat(adele1.hashCode()).isNotEqualTo(cher.hashCode());
        assertThat(empty.hashCode()).isNotNull().isNotEqualTo(cher.hashCode());
    }

    @Test
    public void should_implement_comparable() {
        Act adele = new Act("Adele");
        Act cher = new Act("Cher");
        Act pink = new Act("P!nk");

        SortedSet<Act> acts = TreeSet.of(pink, cher, adele);

        assertThat(acts).hasSize(3).containsExactly(adele, cher, pink);
    }
}
