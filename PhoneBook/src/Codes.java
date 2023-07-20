enum Codes {
    SEARCH(0), PRINT(1), ADD(2), EDIT(3), DELETE(4), EXIT(5);


    // CALL(7) EDIT(2) SORT(3) SAVE(6) DELETE(5)
    public int getCode() {
        return code;
    }

    Codes(int code) {
        this.code = code;
    }

    public static Codes getEnumByCode(int code) throws Exception {
        for (Codes c : Codes.values()) {
            if (c.code == code) {
                return c;
            }
        }
        throw new Exception("Error code");
    }

    private final int code;
}