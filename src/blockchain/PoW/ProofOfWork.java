package blockchain.PoW;

import blockchain.Block.Block;
import blockchain.Utils.BlockUtils;
import blockchain.Utils.HashUtil;

import java.math.BigInteger;

public class ProofOfWork {
    //1)定义Pow类，内部含有两个属性，区块和目标难度值，私有化构造器，并设定newProofofWork（
    //Block block）方法来创建单例
    private Block block;
    private BigInteger target;
    public static final int TARGET_BITS = 20;//前面有20/4=5个0

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public BigInteger getTarget() {
        return target;
    }

    public void setTarget(BigInteger target) {
        this.target = target;
    }

    private ProofOfWork(Block block, BigInteger target) {
        this.block = block;
        this.target = target;
    }

    public static ProofOfWork newProofOfWork(Block block){
         return new ProofOfWork(block, BigInteger.valueOf(1).shiftLeft(256-TARGET_BITS));
    }

    //2)准备数据，就是构造一个函数传入一个nonce值之后进行字段的拼接
    // （前一个区块的哈希值，该区块的数据，时间戳，目标难度，nonce）
    public byte [] prepareData(long nonce){

        byte [] powData = BlockUtils.byteMergerAll(
              this.getBlock().getPrevBlockHash().getBytes(),
                this.getBlock().getData().getBytes(),
                BlockUtils.longToByte(this.getBlock().getTimestamp()),
                this.getTarget().toByteArray(),
                BlockUtils.longToByte(nonce)
        );
                return powData;
    }
    //3)创建一个返回符合要求的nonce和对应hash值的函数run（）
    public PowResult run(){
        long nonce = 0;
        String hashvalue = "";
        System.out.printf("Mining the block containing: %s \n",this.getBlock().getData());
        long startTime = System.currentTimeMillis();
        while(nonce < Long.MAX_VALUE){
            hashvalue = HashUtil.HashSHA256(this.prepareData(nonce));
            if(new BigInteger(hashvalue, 16).compareTo(this.target) == -1){
                System.out.printf("Elapsed Time: %s seconds \n", (float) (System.currentTimeMillis() - startTime) / 1000);
                System.out.printf("correct hash Hex: %s \n\n", hashvalue);
                break;
            }else{
                nonce++;
            }
        }
        PowResult powr = new PowResult(1,"");
        powr.setHashvalue(hashvalue);
        powr.setNonce(nonce);

        return powr;

    }

    //4)创建验证区块是否符合要求的函数validate（）
    public boolean validate() {
        byte[] headers = this.prepareData(this.getBlock().getNonce());
        return new BigInteger(HashUtil.HashSHA256(headers), 16).compareTo(this.target) == -1;
    }

    //5)修改区块添加逻辑，

}
