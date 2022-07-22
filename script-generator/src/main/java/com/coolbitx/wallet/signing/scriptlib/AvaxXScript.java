package com.coolbitx.wallet.signing.scriptlib;

import com.coolbitx.wallet.signing.utils.ScriptArgumentComposer;
import com.coolbitx.wallet.signing.utils.ScriptAssembler;
import com.coolbitx.wallet.signing.utils.ScriptData;

public class AvaxXScript {

    public static void main(String[] args) {
        listAll();
    }

    public static void listAll() {
        System.out.println("normal transaction: " + sendAvaxX());
    }

    public static String sendAvaxX() {
        ScriptArgumentComposer sac = new ScriptArgumentComposer();
        ScriptData argOutput = sac.getArgument(164);
        ScriptData argInput = sac.getArgument(92);
        ScriptData argMemo = sac.getArgumentAll();

        String script = new ScriptAssembler()
                .setCoinType(0X2328)
                // codeID
                .copyString("0000")
                // typeID
                .copyString("00000000")
                // networkID
                .copyString("00000005")
                // blockchainID
                .copyString("ab68eb1ee142a05cfe768c36e11f0b596db5a3c6c77aabe665dad9e638ca94f7")
                // number of output
                .copyArgument(argOutput)
                .copyArgument(argInput)
                .copyArgument(argMemo)
                .showMessage("AVAX")
                .showWrap("NORMAL", "")
                .showPressButton()
                .setHeader(ScriptAssembler.HashType.SHA256, ScriptAssembler.SignType.ECDSA)
                .getScript();
        return script;
    }
}
