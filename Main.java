package com.company;

public class Main {

    /**
     * Метод "скидка". Применяет скидку discount к цене price, начиная с позиции offset
     * на количество позиций readLength. Новые цены округляем “вниз”,
     * до меньшего целого числа.
     * @param price исходные цены, цена должна быть больше нуля
     * @param discount % скидки, должен попадать в диапазон от 1 до 99
     * @param offset номер позиции, с которой нужно применить скидку, должен быть больше или равен нулю
     * @param readLength количество позиций, к которым нужно применить скидку, должно быть больше нуля
     * @return массив новых цен
     */
    public int[] decryptData( int[] price,
                              int discount,
                              int offset,
                              int readLength) {
        if (discount < 1 || discount > 99){
            throw new IllegalArgumentException(
                    String.format("Value of the \"discount\" argument (your value = %d) must be between 1 and 99", discount)
            );
        }
        if (offset < 0){
            throw new IllegalArgumentException(
                    String.format("Value of the \"offset\" argument (your value = %d) must be greater than or equal to zero", offset)
            );
        }
        if (readLength < 1){
            throw new IllegalArgumentException(
                    String.format("Value of the \"readLength\" argument (your value = %d) must be greater than zero", readLength)
            );
        }
        if (price.length < offset+readLength){
            throw new IllegalArgumentException(
                    "The combination of the values of the \"offset\" and \"readLength\" arguments exceeds the length of the \"price\" array"
            );
        }
        float floatDiscount = discount;
        int[] newPrice = new int[readLength];
        for (int i = offset; i < offset+readLength; i++) {
            float floatPrice = price[i];
            newPrice[i-offset] = (int)(floatPrice - floatPrice * floatDiscount * 0.01);
        }
        return newPrice;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] price = {5,100,20,66,16};
        int discount = 50;
        int offset = 1;
        int readLength = 3;
        int[] newPrice = main.decryptData(price, discount, offset, readLength);
        System.out.println("Цены со скидкой:");
        for (int i: newPrice) {
            System.out.println(i);
        }
    }
}
