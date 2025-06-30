import java.util.Scanner;

class Node {
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class CustomerQueue {
    private Node head, tail;

    // menambahkan ke belakang antrian
    public void push(String name){
        Node newNode = new Node(name);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println( " " + name);
    }

    // melayani pelanggan dari antrian yang didepan
    public String pop(){
        if (head == null){
            return null;
        } else {
            String name = head.name;
            head = head.next;
            return name;
        }
    }

    // menampilkan seluruh antrian
    public String showQueueList(){
       if (head == null){
           System.out.println("Queue is empty");
       } else {
           System.out.println("\nCurrent Queue List :");
           Node current = head;
           while (current != null){
               System.out.println(" " + current.name);
               current = current.next;
           }
       }
       return null;

    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       CustomerQueue queue = new CustomerQueue();

        System.out.println("--Aplikasi Antrian Restoran--");

        while(true){
            System.out.println("\nMenu:");
            System.out.println("1. Tambahkan Antrian Pelanggan:");
            System.out.println("2. Layani Antrian");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Keluar");
            System.out.println("Pilih opsi: ");

            int pilihan = -1;
            try {
                pilihan =scanner.nextInt();
            }catch(Exception e){
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.next(); // Membersihkan buffer scanner
                continue;
            }
            scanner.nextLine(); // Membersihkan newline character dari buffer

            switch(pilihan){
                case 1:
                    System.out.println("Masukkan nama pelanggan: ");
                    String data = scanner.nextLine();
                    queue.push(data);
                    queue.showQueueList();
                    break;

                case 2:
                    queue.pop();
                    System.out.println("Antrian telah dilayani\n");
                    queue.showQueueList();
                    break;

                case 3:
                    queue.showQueueList();
                    break;

                case 4:
                    System.out.println("Keluar dari sistem");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilih tidak valid, silahkan pilih angka 1-4. ");
            }
        }
    }
}