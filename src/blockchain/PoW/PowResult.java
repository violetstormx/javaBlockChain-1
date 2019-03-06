package blockchain.PoW;
//定义一个结构来接收run()的返回值，方便Block中的newBlock函数调用
public class PowResult {
    private long nonce;
    private String hashvalue;

    public PowResult(long nonce, String hashvalue) {
        this.nonce = nonce;
        this.hashvalue = hashvalue;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public String getHashvalue() {
        return hashvalue;
    }

    public void setHashvalue(String hashvalue) {
        this.hashvalue = hashvalue;
    }
}
