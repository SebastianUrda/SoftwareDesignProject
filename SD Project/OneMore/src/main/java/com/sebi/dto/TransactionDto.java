package com.sebi.dto;

public class TransactionDto {
    private String sellerName;
    private String buyerName;
    private int coinId;

    public TransactionDto() {
    }

    public TransactionDto(String sellerName, String buyerName, int coinId) {
        this.sellerName = sellerName;
        this.buyerName = buyerName;
        this.coinId = coinId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public int getCoinId() {
        return coinId;
    }

    public void setCoinId(int coinId) {
        this.coinId = coinId;
    }
}
