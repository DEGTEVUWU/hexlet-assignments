package exercise;

class SafetyList {
    // BEGIN
    private int[] massive = new int[0];
    public SafetyList(int[] massive) {
        this.massive = massive;
    }
    public SafetyList() {
    }

    public synchronized void add(int value) {
        int[] newMassive = new int[massive.length + 1];
        System.arraycopy(massive, 0, newMassive, 0, massive.length);
        newMassive[massive.length] = value;
        massive = newMassive;
    }
    public int get(int value) {
        return massive[value];
    }
    public int getSize() {
        return massive.length;
    }
    // END
}
