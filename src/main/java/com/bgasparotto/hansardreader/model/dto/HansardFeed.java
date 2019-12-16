package com.bgasparotto.hansardreader.model.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.Instant;
import java.util.List;

@Data
@XmlRootElement(name = "feed")
@XmlAccessorType(XmlAccessType.FIELD)
public class HansardFeed {
    private String id;
    private String title;
    private Instant updated;

    @XmlElement(name = "entry")
    private List<HansardEntry> entries;
}
