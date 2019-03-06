package blockchain.Block;

import java.util.LinkedList;

public class BlockChain {

    private LinkedList<Block> blockLinkedList;
    public LinkedList<Block> getBlockLinkedList() {
        return blockLinkedList;
    }

    //可以不传入值直接创建创世区块并创建区块链

    public BlockChain(){
        LinkedList<Block> blocks = new LinkedList<Block>();
        blocks.add(Block.newgenesisBlock());
        this.blockLinkedList = blocks;
    }

    //可以传入已有的区块链设定当前区块链
    public BlockChain(LinkedList<Block> blockLinkedList){
        this.blockLinkedList = blockLinkedList;
    }


    //留个口为pow做准备
    public void addBlock(String data){
        this.blockLinkedList.add(Block.newBlock(this.blockLinkedList.getLast().getPrevBlockHash(),data));
    }
}


