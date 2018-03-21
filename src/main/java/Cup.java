public class Cup {
    private int _maxVolume;

    public int getMaxVolume() {
        return _maxVolume;
    }

    public void setMaxVolume(int value) {
        this._maxVolume = value;
    }

    public void showCupInfo(){
        System.out.println("Puodelio talpa yra: "+_maxVolume);
    }
}
