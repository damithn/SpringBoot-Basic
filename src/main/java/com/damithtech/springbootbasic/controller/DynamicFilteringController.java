package com.damithtech.springbootbasic.controller;

import com.damithtech.springbootbasic.model.DyanamicFilteringBean;
import com.damithtech.springbootbasic.model.StaticFiletringBean;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DAMITH SAMARAKOON on 8/4/2020
 */
@RestController
public class DynamicFilteringController {
    @GetMapping("/dyanamic-filtering")
    public MappingJacksonValue getDyanamicFilteringBean(){
        DyanamicFilteringBean dyanamicFilteringBean = new DyanamicFilteringBean("f1", "f2", "f3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filterProviders = new SimpleFilterProvider().addFilter("BeanFilter", filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dyanamicFilteringBean);
        mappingJacksonValue.setFilters(filterProviders);

        return mappingJacksonValue;
    }
}
