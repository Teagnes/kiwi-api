package com.kiwi.doc.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HighLightDocEntity extends DocEntity{

    private List<String>  highLight;

}
