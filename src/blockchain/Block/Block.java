package blockchain.Block;

import blockchain.PoW.PowResult;
import blockchain.PoW.ProofOfWork;
import blockchain.Utils.BlockUtils;
import blockchain.Utils.HashUtil;

public class Block {
    private long Timestamp; //时间戳
    private String Data;    //交易数据
    private String PrevBlockHash; //前一个区块的hash
    private String Hash;   //当前区块的hash
    private long Nonce;  //随机数



    public long getNonce() {
        return Nonce;
    }

    public void setNonce(long nonce) {
        Nonce = nonce;
    }

    //构造方法，构造区块的时候需要时间戳，交易数据，和先前区块的hash
    public Block(long timestamp, String data, String prevBlockHash,String hash) {

        Timestamp = timestamp;
        Data = data;
        PrevBlockHash = prevBlockHash;
        Hash = hash;
    }

    public long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(long timestamp) {
        Timestamp = timestamp;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getPrevBlockHash() {
        return PrevBlockHash;
    }

    public void setPrevBlockHash(String prevBlockHash) {
        PrevBlockHash = prevBlockHash;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String hash) {
        Hash = hash;
    }

    //生成新区块的方法，需要传入前一个区块的hash和区块中的交易数据（字符串格式）
    public static Block newBlock(String prevBlockHash,String data){


        Block block = new Block(System.currentTimeMillis(),data,prevBlockHash,"");
        ProofOfWork pow = ProofOfWork.newProofOfWork(block);
        PowResult powr = pow.run();
        block.setHash(powr.getHashvalue());
        block.setNonce(powr.getNonce());

        return block;
    }

//    //通过区块已有的字段计算hash值
//    private void setHash(){
//
//        byte[] headers = BlockUtils.byteMergerAll(
//                this.getPrevBlockHash().getBytes(),
//                this.getData().getBytes(),
//                BlockUtils.longToByte(this.getTimestamp())
//                );//拼接byte数组
//
//    }

    public static Block newgenesisBlock(){
        return newBlock("","Geneisis Block");
    }
}

