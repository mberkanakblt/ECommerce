package com.mehmetberkan.ecommerce.config;

public class RestApis {
    private static final String VERSION = "/v1";
    private static final String DEV = "/dev";
    private static final String BASE_URL = DEV + VERSION;

    public static final String KULLANICI = BASE_URL+"/kullanici";
    public static final String KATEGORI = BASE_URL+"/kategori";
    public static final String URUN= BASE_URL+"/urun";
    public static final String SEPET= BASE_URL+"/sepet";

    public static final String DOREGİSTER = "/register";
    public static final String LOGIN = "/login";
    public static final String UP_DOWN_SEPET = "/up-down-sepet";
    public static final String ADD_SEPET = "/add-sepet";
    public static final String CLEAR_SEPET = "/clear-sepet";
    public static final String DELETE_URUN= "/delete-urun";
    public static final String ADD_KATEGORI = "/add-kategori";
    public static final String GET_ALL_SEPET = "/get-all-sepet";
    public static final String REMOVE_IN_SEPET = "/remove-in-sepet";
    public static final String GET_MAIN_KATEGORİ = "/get-main-kategori";
    public static final String GET_SUB_KATEGORI = "/get-sub-kategori";
    public static final String ADD_URUN= "/add-urun";
    public static final String GET_ALL_URUN= "/get-all-urun";
    public static final String GET_URUN_BY_NAME= "/get-urun-by-name";
    public static final String REDUCE_STOCK= "/reduce-stock";
    public static final String INCREASE_STOCK= "/increase-stock";
    public static final String GET_URUN= "/get-urun";
}
