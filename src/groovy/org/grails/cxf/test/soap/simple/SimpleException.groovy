package org.grails.cxf.test.soap.simple

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement

/**
 */
@XmlAccessorType(XmlAccessType.NONE)
class SimpleException {

    @XmlElement
    String message

    SimpleException() { }

    SimpleException(String message) {
        this.message = message
    }
}
