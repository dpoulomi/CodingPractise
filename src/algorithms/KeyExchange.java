package algorithms;

// This program calculates the Key for two persons
// using the Diffie-Hellman Key exchange algorithm
class KeyExchange {

  private static long power(long a, long b, long p) {
    if (b == 1)
      return a;
    else
      return (((long) Math.pow(a, b)) % p);
  }

  public static void main(String[] args) {
    long P, G, x, a, y, b, key1, key2;

    // Both the persons will be agreed upon the
    // public keys G and P

    // A prime number P is taken
    P = 23;

    // A primitive root for P, G is taken
    G = 9;

    // Alice will choose the private key a
    // a is the chosen private key
    a = 4;

    // Gets the generated key
    x = power(G, a, P);

    // Bob will choose the private key b
    // b is the chosen private key
    b = 3;

    // Gets the generated key
    y = power(G, b, P);

    // Generating the secret key after the exchange
    // of keys
    key1 = power(y, a, P); // Secret key for Alice
    key2 = power(x, b, P); // Secret key for Bob

    System.out.println("Secret key for the Alice is:" + key1);
    System.out.println("Secret key for the Bob is:" + key2);
  }
}
