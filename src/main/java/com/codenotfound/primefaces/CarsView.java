package com.codenotfound.primefaces;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class CarsView implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private CarRepository carRepository;

  private List<Car> cars;

  @PostConstruct
  public void init() {
    cars = carRepository.findAll();
  }

  public List<Car> getCars() {
    return cars;
  }

  public void onPageChange(AjaxBehaviorEvent event){
    System.out.println("ciao");
    setText("Page event triggered");
  }

  private String text = "start";

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


}
