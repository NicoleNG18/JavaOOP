package com.company.TestDrivenDevelopment.Chainblock;

import java.util.*;

public class ChainblockImplTest {
    private Chainblock database;
    private List<Transaction> transactions;

    @Before
    public void setUp() {
        database = new ChainblockImpl();
        transactions = new ArrayList<>();
        prepareTransactions();

    }

    private void prepareTransactions() {
        Transaction transaction1 = new TransactionImpl
                (12, TransactionStatus.SUCCESSFUL, "nikole", "ivan", 125.32);
        Transaction transaction2 = new TransactionImpl
                (13, TransactionStatus.SUCCESSFUL, "pesho", "niki", 126.32);
        Transaction transaction3 = new TransactionImpl
                (14, TransactionStatus.ABORTED, "nikole", "komi", 127.32);
        Transaction transaction4 = new TransactionImpl
                (19, TransactionStatus.SUCCESSFUL, "kole", "niki", 129.32);
        Transaction transaction5 = new TransactionImpl
                (17, TransactionStatus.SUCCESSFUL, "nikole", "vitq", 131.32);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);
    }


    @Test
    public void testGetCountMethod() {
        addFiveTransactionsToTheDb();
        Assert.assertEquals(transactions.size(), database.getCount());
    }

    @Test
    public void testGetCountMethodWithRepeatedTransactions() {
        database.add(transactions.get(0));
        database.add(transactions.get(0));
        Assert.assertEquals(1, database.getCount());
    }

    @Test
    public void testAddAndContainsWithTransactionShouldReturnFalseBeforeAddingAndTrueAfterIt() {
        Assert.assertFalse(database.contains(transactions.get(0)));
        database.add(transactions.get(0));
        Assert.assertTrue(database.contains(transactions.get(0)));
    }

    @Test
    public void testContainsByIdShouldReturnTrueIfIdIsPresentAndFalseIfItNot() {
        Assert.assertFalse(database.contains(transactions.get(0).getId()));
        database.add(transactions.get(0));
        Assert.assertTrue(database.contains(transactions.get(0).getId()));
    }

    @Test
    public void testChangeTransactionStatusWithValidId() {
        database.add(transactions.get(0));
        database.changeTransactionStatus(12, TransactionStatus.UNAUTHORIZED);
        Assert.assertEquals(TransactionStatus.UNAUTHORIZED, transactions.get(0).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowExceptionWithInvalidId() {
        database.add(transactions.get(0));
        this.database.changeTransactionStatus(13, TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByIdWithPresentId() {
        database.add(transactions.get(0));
        Transaction actual = database.getById(12);
        Assert.assertEquals(transactions.get(0), actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdWithInvalidIdShouldThrowException() {
        database.add(transactions.get(0));
        database.getById(13);

    }

    @Test
    public void testRemoveByIdShouldRemoveCorrectTransaction() {
        database.add(transactions.get(0));
        database.add(transactions.get(1));
        database.removeTransactionById(12);
        Assert.assertEquals(1, database.getCount());
        Assert.assertFalse(database.contains(12));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveByIdShouldThrowException() {
        database.add(transactions.get(0));
        database.removeTransactionById(13);
    }

    @Test
    public void testgGetByTransactionStatusWithPresentStatus() {
        addFiveTransactionsToTheDb();
        List<Transaction> expected = transactions.stream()
                .filter(e -> e.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).toList();
        List<Transaction> actual = convertIterableTransactionToList(database.getByTransactionStatus(TransactionStatus.SUCCESSFUL));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowException() {
        addFiveTransactionsToTheDb();
        database.getByTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusWithInvalidStatusShouldThrowException() {
        addFiveTransactionsToTheDb();
        database.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldReturnTheCorrectsSendersInCorrectOrder() {
        addFiveTransactionsToTheDb();
        List<String> expected = transactions.stream()
                .filter(e -> e.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getSender).toList();
        List<String> actual = convertIterableStringToList
                (database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllRecieversWithTransactionStatusWithInvalidStatusShouldThrowException() {
        addFiveTransactionsToTheDb();
        database.getAllReceiversWithTransactionStatus(TransactionStatus.FAILED);
    }

    @Test
    public void testGetAllRecieversWithTransactionStatusShouldReturnTheCorrectsSendersInCorrectOrder() {
        addFiveTransactionsToTheDb();
        List<String> expected = transactions.stream()
                .filter(e -> e.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getReceiver).toList();
        List<String> actual = convertIterableStringToList
                (database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenById() {
        addFiveTransactionsToTheDb();
        List<Transaction> expected = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .toList();
        List<Transaction> actual = convertIterableTransactionToList(database.getAllOrderedByAmountDescendingThenById());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowExceptionWithInvalidSender() {
        addFiveTransactionsToTheDb();
        database.getBySenderOrderedByAmountDescending("boiko");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnTheCorrectTransactionsInCorrectOrder() {
        addFiveTransactionsToTheDb();
        List<Transaction> expected = transactions.stream()
                .filter(e -> e.getSender().equals("nikole"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).toList();
        List<Transaction> actual = convertIterableTransactionToList(database.getBySenderOrderedByAmountDescending("nikole"));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowExceptionWithInvalidReciever() {
        addFiveTransactionsToTheDb();
        database.getByReceiverOrderedByAmountThenById("nikolai");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenById() {
        addFiveTransactionsToTheDb();
        List<Transaction> expected = transactions.stream()
                .filter(e -> e.getReceiver().equals("niki"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .toList();
        List<Transaction> actual = convertIterableTransactionToList(database.getByReceiverOrderedByAmountThenById("niki"));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionWithInvalidAmount() {
        addFiveTransactionsToTheDb();
        List<Transaction> transactionList = convertIterableTransactionToList(
                database.getByTransactionStatusAndMaximumAmount(TransactionStatus.FAILED, 25.00));
        Assert.assertTrue(transactionList.isEmpty());

    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionWithInvalidStatus() {
        addFiveTransactionsToTheDb();
        List<Transaction> transactionList = convertIterableTransactionToList(
                database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 100.00));
        Assert.assertTrue(transactionList.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnCorrectElementsInCorrectOrder() {
        addFiveTransactionsToTheDb();
        List<Transaction> expected = transactions.stream()
                .filter(e -> e.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .filter(e -> e.getAmount() <= 130.00)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).toList();
        List<Transaction> actual = convertIterableTransactionToList
                (database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 130.00));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnExceptionWithInvalidSender() {
        addFiveTransactionsToTheDb();
        database.getBySenderAndMinimumAmountDescending("nikolai", 125);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnExceptionWithInvalidAmount() {
        addFiveTransactionsToTheDb();
        database.getBySenderAndMinimumAmountDescending("nikole", 200);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnCorrectElementsInCorrectOrder() {
        addFiveTransactionsToTheDb();
        List<Transaction> expected = transactions.stream()
                .filter(e -> e.getSender().equals("nikole"))
                .filter(e -> e.getAmount() > 125.50)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()).toList();
        List<Transaction> actual = convertIterableTransactionToList(
                database.getBySenderAndMinimumAmountDescending("nikole", 125.50));
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowExceptionWithInvalidReceiver(){
        addFiveTransactionsToTheDb();
        database.getByReceiverAndAmountRange("nikolai",125,127);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowExceptionWithInvalidAmountRange(){
        addFiveTransactionsToTheDb();
        database.getByReceiverAndAmountRange("niki",110,115);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldReturnCorrectElementsInCorrectOrder(){
        addFiveTransactionsToTheDb();
        List<Transaction>expected= transactions.stream()
                .filter(e -> e.getReceiver().equals("niki"))
                .filter(e -> e.getAmount() >= 126.32 && e.getAmount() < 130)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .toList();
        List<Transaction>actual=convertIterableTransactionToList
                (database.getByReceiverAndAmountRange("niki",126.32,130));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAllInAmountRangeWithValidRangeShouldReturnCorrectElementsInCorrectOrder(){
        addFiveTransactionsToTheDb();
        List<Transaction>expected= transactions.stream()
                .filter(e -> e.getAmount() >= 125.32 && e.getAmount() <= 129.32).toList();
        List<Transaction>actual=convertIterableTransactionToList(database.getAllInAmountRange(125.32,129.32));
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetAllInAmountRangeWithValidRangeShouldReturnEmptyCollectionWithInvalidRange(){
        addFiveTransactionsToTheDb();
        List<Transaction>actual=convertIterableTransactionToList(database.getAllInAmountRange(110,112));
        Assert.assertTrue(actual.isEmpty());
    }

    @Test
    public void testTransactionIteratorShouldReturnAllTransactions(){
        List<Transaction> expected= transactions;
        addFiveTransactionsToTheDb();
        Iterator<Transaction> iterator=this.database.iterator();
        Assert.assertNotNull(iterator);
        List<Transaction>actual=new ArrayList<>();

        while (iterator.hasNext()){
            actual.add(iterator.next());
        }

        Assert.assertEquals(expected,actual);
    }

    private void addFiveTransactionsToTheDb() {
        database.add(transactions.get(0));
        database.add(transactions.get(1));
        database.add(transactions.get(2));
        database.add(transactions.get(3));
        database.add(transactions.get(4));
    }

    private List<String> convertIterableStringToList(Iterable<String> iterable) {
        List<String> transactionList = new ArrayList<>();
        Assert.assertNotNull(iterable);
        iterable.forEach(transactionList::add);
        return transactionList;
    }

    private List<Transaction> convertIterableTransactionToList(Iterable<Transaction> iterable) {
        List<Transaction> transactionList = new ArrayList<>();
        Assert.assertNotNull(iterable);
        iterable.forEach(transactionList::add);
        return transactionList;
    }
}
