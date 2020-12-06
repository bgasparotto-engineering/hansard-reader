package com.bgasparotto.hansardreader.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.FIELD)
public class HansardResourceLink {

    @NotBlank(message = "Resource link URI can't be blank")
    @XmlAttribute(name = "href")
    private String uri;
}
