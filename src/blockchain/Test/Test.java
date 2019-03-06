package blockchain.Test;

import blockchain.Block.Block;
import blockchain.Block.BlockChain;
import blockchain.PoW.ProofOfWork;
import blockchain.Utils.HashUtil;
import jdk.nashorn.internal.ir.BlockLexicalContext;

public class Test {
    public static void main(String[] args) {

        BlockChain blockChain =  new BlockChain();
        blockChain.addBlock("Send 1 BTC to Ivan");
        blockChain.addBlock("Send 2  more BTC to Ivan");

        for (Block block : blockChain.getBlockLinkedList()) {
            System.out.println("Prev.hash: "+block.getPrevBlockHash());
            System.out.println("Data: "+block.getData());
            System.out.println("Hash: "+block.getHash());
            System.out.println("Nonce: "+block.getNonce());

            ProofOfWork pow = ProofOfWork.newProofOfWork(block);
            System.out.println("Pow valid: " +  pow.validate() + "\n");


        }

    }
    }



