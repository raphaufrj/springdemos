package br.com.resteasy.app.interfaces;

import java.io.Serializable;

public interface IDto extends Serializable {

    String getId();

    void setId(final String id);

}
