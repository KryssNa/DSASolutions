package Hash;

public class LinearProbing {
    int keytable[];
    int valuetable[];
    int size;
    LinearProbing(int Size){
        this.size=size;
        keytable=new int[size];
        valuetable=new int[size];
        for(int i=0;i<size;i++){
            keytable[i]=-1;
            valuetable[i]=-1;
        }
    }

    int hashFuncation(int key){
        return (2*key+3)%size;
    }

    void insert(int key, int value){
        int location=hashFuncation(key);
        int temp=location;
        do {
            if (keytable[location] == -1) {
                keytable[location] = key;
                valuetable[location] = value;
                return;
            }
            if (keytable[location] == key) {
                valuetable[location] = value;
                return;
            }

            location = (location + 1) % size;
        }
        while(location!=temp);

    }

    int get(int key){
        int location=hashFuncation(key);
        int temp=location;
        while(keytable[location]!=key){
            location = (location + 1) % size;
        }
        if(temp!=location){
            return valuetable[location];
        }
        return -1;
    }
}
