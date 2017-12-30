package com.example.android.endate.database;

public class ProductDbSchema {
    public static final class ProductTable {
        public static final String NAME = "products";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME= "name";
            public static final String DATE = "date";
        }
    }
}
