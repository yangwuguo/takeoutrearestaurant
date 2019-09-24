package cn.wanxi.manage.web.dao;

import cn.wanxi.manage.web.model.Catelog;

import java.util.List;

public interface ICatelog {

    List<Catelog> getIDByName(String name);

    List<Catelog> getCatelogName();

}
