package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

    //Display all regions in Canada

    List<Region> findByCountry(String country);

    //Display all regions with country name includes 'United'

    List<Region> findByCountryContaining(String country);

    //Display all regions with country name includes United in order(region)

    List<Region> findByCountryContainingOrderByRegion(String country);

    //Display top 2 regions in United States

    List<Region> findTop2ByCountry(String country);
    List<Region> findTopByCountry(String country);
    List<Region> findTop3ByCountry(String country);

    List<Region> findTopByCountryContainsOrderByRegion(String country);




}
