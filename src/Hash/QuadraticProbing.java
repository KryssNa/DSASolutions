package Hash;

public class QuadraticProbing {
    int keytable[];
    int valuetable[];
    int size;
    QuadraticProbing(int Size){
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

        int i=0;
        while(keytable[location] !=-1 && i<size){
            if(keytable[location]==key){
                valuetable[location]=value;
                return;
            }
            location=(location+i*i)%size;
            i++;
            keytable[location]=key;
            valuetable[location]=value;
        }

    }

    int get(int key){
        int location=hashFuncation(key);
        int temp=location;
        int i=0;
        while(keytable[location]!=key){
            location = (location + i*i) % size;
            i++;
        }
        if(temp!=location){
            return valuetable[location];
        }
        return -1;
    }
}
