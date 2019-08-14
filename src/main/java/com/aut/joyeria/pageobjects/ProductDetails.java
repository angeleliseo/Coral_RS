package com.aut.joyeria.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/*
 This class needs a different way to locate the objects since those objects are depending on product id the ones changes
 XPath optimization required probably a function can be used like contains.
 * */
public class ProductDetails {

	private By btnAlCarrito;
	private By txtCantidad;
	private By lnkDescripcion;
	private By lnkValoraciones;
	private By lblAddedToCart;
	private WebDriver driver;
	
	public ProductDetails(WebDriver driver) {
		this.driver = driver;
		btnAlCarrito = By.className("single_add_to_cart_button");
		txtCantidad = By.name("quantity");
		lnkDescripcion = By.cssSelector("#blog > div > div.row.rsrc-content > div > div > div > div.woocommerce-tabs.wc-tabs-wrapper > ul > li.description_tab.active > a");
		lnkValoraciones = By.cssSelector("#blog > div > div.row.rsrc-content > div > div > div > div.woocommerce-tabs.wc-tabs-wrapper > ul > li.reviews_tab.active > a");
		lblAddedToCart = By.xpath("//*[@id=\"blog\"]/div/div[4]/div/div/div[1]");
	}
	
	public void añadirAlCarro(int cantidad) {
		if (cantidad >0) {
			driver.findElement(txtCantidad).clear();
			driver.findElement(txtCantidad).sendKeys(""+cantidad);
			driver.findElement(btnAlCarrito).click();
		}
	}
	public void setProducto(String productURL) {
		driver.navigate().to(productURL);		
	}
	public boolean setProducto(String searchProduct, MainMenu menu) {
		if (menu.search(searchProduct))
			return true;
		else
			return false;
	}
	
	public void verDescripcion() {
		driver.findElement(lnkDescripcion).click();
	}
	public void verValoracion() {
		driver.findElement(lnkValoraciones).click();
	}
	
	public boolean addToCartVerify() {
		if (driver.findElement(lblAddedToCart).getText().contains("se ha añadido a tu carrito")) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean addToCartVerifySeveral() {
		if (driver.findElement(lblAddedToCart).getText().contains("han sido añadidos a tu carrito")) {
			return true;
		}else {
			return false;
		}		
	}
}
