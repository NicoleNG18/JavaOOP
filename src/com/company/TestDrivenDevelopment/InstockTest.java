package com.company.TestDrivenDevelopment;

import java.util.*;

public class InstockTest {

    private static final Product PRODUCT_ONE = new Product("Che", 2.4, 15);
    private static final Product PRODUCT_TWO = new Product("Chese", 2.6, 4);
    private static final Product PRODUCT_THREE = new Product("Check", 2.8, 6);
    private static final Product PRODUCT_FOUR = new Product("fourth", 2.4, 8);
    private static final Product PRODUCT_FIVE = new Product("fifth", 3.1, 15);
    private static final int INVALID_INDEX = -1;
    private static final int QUANTITY_CHANGER = 7;
    private static final int COUNT_ADDED_PRODUCTS = 5;

    private ProductStock stock;

    @Before
    public void setUp() {
        this.stock = new Instock();
    }

    private Product[] fillTheStock() {

        Product[] products = new Product[COUNT_ADDED_PRODUCTS];

        products[0] = PRODUCT_ONE;
        products[1] = PRODUCT_TWO;
        products[2] = PRODUCT_THREE;
        products[3] = PRODUCT_FOUR;
        products[4] = PRODUCT_FIVE;

        stock.add(PRODUCT_ONE);
        stock.add(PRODUCT_TWO);
        stock.add(PRODUCT_THREE);
        stock.add(PRODUCT_FOUR);
        stock.add(PRODUCT_FIVE);

        return products;
    }

    @Test
    public void testContainsShouldReturnFalseWhenTheProductIsAbsentAndTrueIfAdded() {
        //this method tests both add and contains methods
        Assert.assertFalse(stock.contains(PRODUCT_ONE));
        stock.add(PRODUCT_TWO);
        Assert.assertTrue(stock.contains(PRODUCT_TWO));
    }

    @Test
    public void testTheCountOfProductsShouldReturnTrueWithFullCollectionAndFalseWithEmptyCollection() {
        Assert.assertEquals(0, stock.getCount());
        fillTheStock();
        Assert.assertEquals(COUNT_ADDED_PRODUCTS, stock.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithNegativeIndex() {
        stock.find(INVALID_INDEX);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithHigherIndex() {
        fillTheStock();
        stock.find(5);
    }

    @Test()
    public void testFindWithValidIndex() {
        fillTheStock();
        Product finded = stock.find(1);
        Assert.assertEquals(PRODUCT_TWO, finded);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangingQuantityWithInvalidName() {
        fillTheStock();
        stock.changeQuantity("Chesen", QUANTITY_CHANGER);
    }

    @Test()
    public void testChangingQuantityWithValidName() {
        fillTheStock();
        stock.changeQuantity("Che", QUANTITY_CHANGER);
        Assert.assertEquals(QUANTITY_CHANGER, stock.findByLabel("Che").quantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindingByLabelWithNonExistingLabel() {
        fillTheStock();
        stock.findByLabel("Chesen");
    }

    @Test
    public void testFindingByLabelWithExistingLabel() {
        fillTheStock();
        Product finded = stock.findByLabel("Chese");
        Assert.assertEquals(PRODUCT_TWO, finded);
    }

    @Test
    public void testfindFirstMostExpensiveProductsReturnsCorrectProducts() {
        int productsToTake = 2;
        List<Product> expected = Arrays.stream(fillTheStock())
                .limit(productsToTake)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
        List<Product> actual = convertIterableToList(stock.findFirstMostExpensiveProducts(productsToTake));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testfindFirstMostExpensiveProductsThrowsExceptionWithLessProducts() {
        int productsToTake = 6;
        stock.findFirstMostExpensiveProducts(productsToTake);
    }

    @Test
    public void testFindAllByPriceShouldReturnCorrectProducts() {
        double price = 2.4;
        List<Product> expected = Arrays.stream(fillTheStock()).
                filter(e -> e.getPrice() == price).toList();
        List<Product> actual = convertIterableToList(stock.findAllByPrice(price));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollection() {
        fillTheStock();
        double price = 4.2;
        List<Product> actual = convertIterableToList(stock.findAllByPrice(price));
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindAllByQuantityShouldReturnCorrectProducts() {
        int quantity = 15;
        List<Product> expected = Arrays.stream(fillTheStock()).
                filter(e -> e.getQuantity() == quantity).toList();
        List<Product> actual = convertIterableToList(stock.findAllByQuantity(quantity));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByQuantityShouldReturnEmptyCollection() {
        fillTheStock();
        int quantity = 2;
        List<Product> actual = convertIterableToList(stock.findAllByQuantity(quantity));
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnCorrectProducts() {
        double lowPrice = 2.3;
        double highPrice = 2.8;
        List<Product> expected = Arrays.stream(fillTheStock())
                .filter(e -> e.getPrice() > lowPrice && e.getPrice() <= highPrice)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .toList();
        List<Product> actual = convertIterableToList(stock.findAllInRange(lowPrice, highPrice));
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollection() {
        fillTheStock();
        double lowPrice = 1.0;
        double highPrice = 1.2;
        List<Product> actual = convertIterableToList(stock.findAllInRange(lowPrice, highPrice));
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectCollection() {
        int count = 3;
        List<Product> expected = Arrays.stream(fillTheStock())
                .limit(count)
                .sorted(Comparator.comparing(Product::getLabel))
                .toList();
        List<Product> actual = convertIterableToList(stock.findFirstByAlphabeticalOrder(count));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollection() {
        int count = 7;
        List<Product> actual = convertIterableToList(stock.findFirstByAlphabeticalOrder(count));
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testProductIteratorShouldReturnAllProducts(){
        List<Product> expected= Arrays.stream(fillTheStock()).toList();

        Iterator<Product> iterator=this.stock.iterator();
        Assert.assertNotNull(iterator);
        List<Product>actual=new ArrayList<>();

        while (iterator.hasNext()){
            actual.add(iterator.next());
        }

        Assert.assertEquals(expected,actual);
    }
    private List<Product> convertIterableToList(Iterable<Product> products) {
        Assert.assertNotNull(products);

        List<Product> productsMap = new ArrayList<>();
        products.forEach(productsMap::add);

        return productsMap;
    }
}
