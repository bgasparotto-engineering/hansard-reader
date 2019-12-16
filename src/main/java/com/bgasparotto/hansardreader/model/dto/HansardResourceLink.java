package com.bgasparotto.hansardreader.model.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "link")
@XmlAccessorType(XmlAccessType.FIELD)
public class HansardResourceLink {

    @XmlAttribute(name = "href")
    private String uri;
}
