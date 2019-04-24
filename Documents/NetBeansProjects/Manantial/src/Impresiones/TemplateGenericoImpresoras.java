/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Impresiones;

/**
 *
 * @author andy
 */
public interface TemplateGenericoImpresoras {
            /*
        TM-U220 SUPPORTED COMMANDS
        Command Classification Name Function type
        HT E XECUTING COMMAND Horizontal tab P RINT POSITION COMMANDS
        LF E XECUTING COMMAND Print and line feed P RINT COMMANDS
        CR E XECUTING COMMAND Print and carriage return P RINT COMMANDS
        DLE EOT E XECUTING COMMAND Transmit real-time status S TATUS COMMANDS
        DLE ENQ E XECUTING COMMAND Send real-time request to printer M ISCELLANEOUS COMMANDS
        DLE DC4 (fn = 1) E XECUTING COMMAND Generate pulse in real-time M ISCELLANEOUS COMMANDS
        ESC SP S ETTING COMMAND Set right-side character spacing C HARACTER COMMANDS
        ESC ! S ETTING COMMAND Select print mode(s) C HARACTER COMMANDS
        ESC % S ETTING COMMAND Select/cancel user-defined character set C HARACTER COMMANDS
        ESC & S ETTING COMMAND Define user-defined characters C HARACTER COMMANDS
        ESC ( A E XECUTING + S ETTING Control beeper tones M ISCELLANEOUS COMMANDS
        ESC ✻ E XECUTING COMMAND Select bit-image mode B IT - IMAGE COMMANDS
        ESC – S ETTING COMMAND Turn underline mode on/off C HARACTER COMMANDS
        ESC 2 S ETTING COMMAND Select default line spacing L INE SPACING COMMANDS
        ESC 3 S ETTING COMMAND Set line spacing L INE SPACING COMMANDS
        Paper roll
        TM-U220 supported commands
        Ver. 10.05 p. 44CONFIDENTIAL
        Command Classification Name Function type
        ESC < E XECUTING COMMAND Return home M ECHANISM CONTROL COMMANDS
        ESC = S ETTING COMMAND Select peripheral device M ISCELLANEOUS COMMANDS
        ESC ? S ETTING COMMAND Cancel user-defined characters C HARACTER COMMANDS
        ESC @ E XECUTING + S ETTING Initialize printer M ISCELLANEOUS COMMANDS
        ESC D S ETTING COMMAND Set horizontal tab positions P RINT POSITION COMMANDS
        ESC E S ETTING COMMAND Turn emphasized mode on/off C HARACTER COMMANDS
        ESC G S ETTING COMMAND Turn double-strike mode on/off C HARACTER COMMANDS
        ESC J E XECUTING COMMAND Print and feed paper P RINT COMMANDS
        ESC K E XECUTING COMMAND Print and reverse feed P RINT COMMANDS
        ESC M S ETTING COMMAND Select character font C HARACTER COMMANDS
        ESC R S ETTING COMMAND Select an international character set C HARACTER COMMANDS
        ESC U S ETTING COMMAND Turn unidirectional print mode on/off M ECHANISM CONTROL COMMANDS
        ESC a S ETTING COMMAND Select justification P RINT POSITION COMMANDS
        ESC c 3 S ETTING COMMAND Select paper sensor(s) to output paper-end
        signals P APER SENSOR COMMANDS
        ESC c 4 S ETTING COMMAND Select paper sensor(s) to stop printing P APER SENSOR COMMANDS
        ESC c 5 S ETTING COMMAND Enable/disable panel buttons P ANEL BUTTON COMMAND
        ESC d E XECUTING COMMAND Print and feed n lines P RINT COMMANDS
            ESC e E XECUTING COMMAND Print and reverse feed n lines P RINT COMMANDS
        ESC i E XECUTING COMMAND Partial cut (one point left uncut) M ECHANISM CONTROL COMMANDS
        ESC m E XECUTING COMMAND Partial cut (three points left uncut) M ECHANISM CONTROL COMMANDS
        ESC p E XECUTING COMMAND Generate pulse M ISCELLANEOUS COMMANDS
        ESC r S ETTING COMMAND Select print color C HARACTER COMMANDS
        ESC t S ETTING COMMAND Select character code table C HARACTER COMMANDS
        ESC u E XECUTING COMMAND Transmit peripheral device status S TATUS COMMANDS
        ESC v E XECUTING COMMAND Transmit paper sensor status S TATUS COMMANDS
        ESC { S ETTING COMMAND Turn upside-down print mode on/off C HARACTER COMMANDS
        FS ! S ETTING COMMAND Select print mode(s) for Kanji characters K ANJI C OMMANDS
        FS & S ETTING COMMAND Select Kanji character mode K ANJI COMMANDS
        FS – S ETTING COMMAND Turn underline mode on/off for Kanji characters K ANJI COMMANDS
        FS . S ETTING COMMAND Cancel Kanji character mode K ANJI COMMANDS
        FS 2 S ETTING COMMAND Define user-defined Kanji characters K ANJI COMMANDS
        FS C S ETTING COMMAND Select Kanji character code system K ANJI COMMANDS
        FS S S ETTING COMMAND Set Kanji character spacing K ANJI COMMANDS
        FS W S ETTING COMMAND Turn quadruple-size mode on/off for Kanji
        characters K ANJI COMMANDS
        FS ? S ETTING COMMAND Cancel user-defined Kanji characters K ANJI COMMANDS
        FS p E XECUTING COMMAND Print NV bit image B IT - IMAGE COMMANDS
        E XECUTING + S ETTING Define NV bit image B IT - IMAGE COMMANDS
        GS ( A E XECUTING COMMAND Execute test print M ISCELLANEOUS COMMANDS
        GS ( C E XECUTING + S ETTING Edit NV user memory C USTOMIZE COMMANDS
        GS ( D S ETTING COMMAND Enable/disable real-time command M ISCELLANEOUS COMMANDS
        GS ( E E XECUTING + S ETTING Set user setup commands C USTOMIZE COMMANDS
        GS I E XECUTING COMMAND Transmit printer ID M ISCELLANEOUS COMMANDS
        GS V E XECUTING COMMAND Select cut mode and cut paper M ECHANISM CONTROL COMMANDS
        GS a E XECUTING + S ETTING Enable/disable Automatic Status Back (ASB) S TATUS COMMANDS
        GS r E XECUTING COMMAND Transmit status S TATUS COMMANDS    
            */
    
    
    
    /**
     * Horizontal tab(HT). Moves the print position to the next horizontal tab position.
     *      <br>&nbsp;■ Horizontal tab positions are set by ESC D.
     *      <br>&nbsp;■ If the next horizontal tab position exceeds the print area, the printer sets the print position to [Print area
     *      width + 1].
     *      <br>&nbsp;■ If this command is processed when the print position is at [Print area width + 1], the printer executes print
     *      buffer-full printing of the current line and horizontal tab processing from the beginning of the next line.
     *      In this case, in page mode, the printer does not execute printing, but the print position is moved.
     *      <br>&nbsp;■ When underline mode is turned on, the underline will not be printed under the tab space skipped by this
     *      command.
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_HorizontalTab();
    
    /**
     * Print and line feed(LF). Prints the data in the print buffer and feeds one line, based on the current line spacing.
     *      <br>&nbsp;■ The amount of paper fed per line is based on the value set using the line spacing command (ESC 2 or
            ESC 3).
     *      <br>&nbsp;■ After printing, the print position moves to the beginning of the line. When a left margin is set in standard
            mode, the position of the left margin is the beginning of the line.
     *      <br>&nbsp;■ When this command is processed in page mode, only the print position moves, and the printer does not
            perform actual printing.
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintLineFeed();
    
    /**
     * Print and carriage return(CR). When auto line feed is enabled executes printing and one line feed as LF.
     * <br> When auto line feed is disabled, Line thermal(This command is ignored); Serial dot head(
     * In standard mode, prints the data in the print buffer and moves the print position to the beginning of the print line.
       In page mode, moves the print position to the beginning of the print line.)
     *  <br>&nbsp;■ With a serial interface, the command performs as if auto line feed is disabled.
        <br>&nbsp;■ With a parallel interface, enabling or disabling the auto line feed can be selected by the DIP switch or the
        memory switch. Memory switch can be changed with GS ( E Function3).
        <br>&nbsp;■ After printing, the print position moves to the beginning of the line. When a left margin is set in standard
        mode, the position of the left margin is the beginning of the line.
        <br>&nbsp;■ When this command is processed in page mode, only the print position moves, and the printer does not
        perform actual printing.
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintAndCarriageReturn();
    
    /**
     * Transmit real-time status(DLE EOT). Transmits the real-time status, using n as follows:
     * <br>     n a Function
       <br>     1 -- Transmit printer status
       <br>     2 -- Transmit offline status
       <br>     3 -- Transmit error status
       <br>     4 -- Transmit roll paper sensor status
       <br>     7 1  Transmit ink status A
       <br>       2  Transmit ink status B
       <br>     8 3  Transmit peeler status
     *  <br>&nbsp;■ This is a real-time command that the printer executes upon receiving it. Take the following into
                consideration:
                <br>&nbsp;• If this command interrupts the code string of another command, this command is processed as a
                parameter of the other command; therefore, the print result will not be correct.
                <br>&nbsp;•If a command such as graphics data or defined data has a code string that is the same as a code string in
                a parameter, the printer processes and then continues with the bit-image or other command.
        <br>&nbsp;■ With a serial interface model, this command is executed even when the printer is offline, the receive
                buffer is full, or an error occurs.
        <br>&nbsp;■ With a parallel interface model, this command is not executed in the following conditions, because the
                printer is busy and unable to receive data from the host computer. The DIP switch (BUSY condition) is
                different, depending on the printer model.
                <br>&nbsp;• Receive buffer is full when DIP switch or memory switch (BUSY condition) is set to On.
                <br>&nbsp;• Printer is offline, an error occurs, or receive buffer is full when DIP switch or memory switch (BUSY
                condition) is set to Off.
        <br>&nbsp;■ This command can be used when the printer is disabled by ESC =.
        <br>&nbsp;■ This command is ignored when transmitting block data (Header ~ NUL).
        <br>&nbsp;■ Each status equals 1 byte.
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TransmitRealTimeStatus(byte n, byte a);
    
    /**
     * Set right-side character spacing(ESC SP). Sets the right-side character spacing to n × (horizontal or vertical motion unit).
     *
     *  <br>&nbsp;■ The character spacing set by this command is effective for alphanumeric, Kana, and user-defined
                characters.
        <br>&nbsp;■ When characters are enlarged, the character spacing is n times normal value. The character spacing for
                double-width mode is twice the normal value.
        <br>&nbsp;■ When standard mode is selected, the horizontal motion unit is used.
        <br>&nbsp;■ When page mode is selected, the vertical or horizontal motion unit is used for the print direction set by
                ESC T.
                <br>&nbsp;•When the starting position is set to the upper left or lower right of the print area using ESC T, the
                horizontal motion unit is used.
                <br>&nbsp;•When the starting position is set to the upper right or lower left of the print area using ESC T, the
                vertical motion unit is used.
        <br>&nbsp;■ The character spacing can be set independently in standard mode and in page mode.
                <br>&nbsp;• In standard mode this command sets the character spacing of standard mode.
                <br>&nbsp;• In page mode this command sets the character spacing of page mode.
        <br>&nbsp;■ If the horizontal or vertical motion unit is changed after this command is executed, the character spacing is
                not changed.
        <br>&nbsp;■ Settings of this command are effective until ESC @ is executed, the printer is reset, or the power is turned
                off.
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_RightSideCharacterSpacing(int n);
    
    /**
     * Select print mode(s) (ESC !). Selects the character font and styles (emphasized, double-height, double-width, and underline) together as
follows:
   
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintMode(int n);
    
    /**
     * Select/cancel user-defined character set (ESC %). Selects or cancels the user-defined character set.
        <br>• When the LSB of n is 0, the user-defined character set is canceled.
        <br>• When the LSB of n is 1, the user-defined character set is selected.
    
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectCancelUserDefinedCharacterSet(int n);
    
    /**
     * Define user-defined characters (ESC &). Defines the user-defined character pattern for the specified character codes.
        <br>• y specifies the number of bytes in the vertical direction.
        <br>• c1 specifies the beginning character code for the definition, and c2 specifies the final code.
        <br>• x specifies the number of dots in the horizontal direction from the left.
        <br>• d specifies the defined data (column format).
        <br>•k indicates the number of defined data. k is an explanation parameter; therefore it does not need to
        be transmitted.
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_DefineUserDefinedCharacters(int n);
    
    /**
     * Define user-defined characters (ESC ( A). Performs the various tasks related to the control of the beeper (listed in the table below).
        <br>Function code (fn) specifies the function.
        <br>•fn Function No. Function name
        <br>48 Function 48 Beeps integrated beeper
        <br>97 Function 97 Beep integrated beeper in TM-U230 models.
        <br>98 Function 98 Set integrated beeper when offline factors occur in TM-U230 models.
        <br>99 Function 99 Set integrated beeper except when offline factors occur in TM-U230
        models.
        <br>pL , pH specifies (pL + pH × 256) as the number of bytes after p H (fn and [parameters]).
        Description of the [parameters] is described in each function.

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_ControlBeeperTones(int n);
    
    /**
     * Select bit-image mode (ESC ✻). Stores the bit image data in the print buffer using the mode specified by bit image mode m as follows:
       <br> m
       <br> 0
       <br> 1
       <br> 32
       <br> 33
       <br> Bit image
       <br> 8-dot single-density
       <br> 8-dot double-density
       <br>  24-dot single-density
       <br> 24-dot double-density
       <br> Mode Number of bits for vertical data
       <br> 8
       <br> 8
       <br> 24
       <br> 24
       <br>Dot density in horizontal
       <br> Single-density
       <br> Double-density
       <br> Single-density
       <br> Double-density
        <br>• n L , n H specifies a bit image in the horizontal direction as (n L + n H × 256) dots.
        <br>• d specifies the bit image data (column format).
        <br>• k indicates the amount of bit image data. k is an explanation parameter; therefore it does not need to
        be transmitted.
        * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectBitImageMode(int n);
    
    /**
     * Turn underline mode on/off (ESC –). Turns underline mode on or off using n as follows:
        <br>n Function
        <br>0, 48 Turns off underline mode
        <br>1, 49 Turns on underline mode (1-dot thick)
        <br>2, 50 Turns on underline mode (2-dots thick)

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TurnUnderlineModeOnOff(int n);
    
    /**
     * Select default line spacing (ESC 2). Sets the line spacing to the “default line spacing.”
      
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectDefaultLineSpacing(int n);
    
    /**
     * Set line spacing (ESC 3). Sets the line spacing to n × (vertical or horizontal motion unit).
      
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SetLineSpacing(int n);
    
    /**
     * Return home (ESC <). Moves the print head to the standby position
      
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_ReturnHome(int n);
    
    /**
     * Select peripheral device (ESC =). Selects the device to which the host computer transmits data, using n as follows:
        <br>n Function
        <br>1,3 Enables printer.
        <br>2 Disables printer.
      
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectPeripheralDevice(int n);
    
    /**
     * Cancel user-defined characters (ESC ?). Deletes the user-defined character pattern specified by character code n.
      
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_CancelUserDefinedCharacters(int n);
    
    /**
     * Initialize printer (ESC @). Clears the data in the print buffer and resets the printer modes to the modes that were in effect when the
        power was turned on.
        <br>• Any macro definitions are not cleared.
        <br>• Offline response selection is not cleared.
        <br>• Contents of user NV memory are not cleared.
        <br>• NV graphics (NV bit image) and NV user memory are not cleared.
        <br>• The maintenance counter value is not affected by this command.
        <br>• The specifying of offline response isn’t cleared.
      
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_InitializePrinter(int n);
    
    /**
     * Set horizontal tab positions (ESC D). Sets horizontal tab positions.
       <br>• n specifies the number of digits from the setting position to the left edge of the print area.
       <br>• k indicates the number of horizontal tab positions to be set.

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SetHorizontalTabPositions(int n);
    
    /**
     * Turn emphasized mode on/off (ESC E). Turns emphasized mode on or off.
            <br>• When the LSB of n is 0, emphasized mode is turned off.
            <br>• When the LSB of n is 1, emphasized mode is turned on.

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TurnEmphasizedModeOnOff(int n);
    
    /**
     * Turn double-strike mode on/off (ESC G). Turns double-strike mode on or off.
            <br>• When the LSB of n is 0, double-strike mode is turned off.
            <br>• When the LSB of n is 1, double-strike mode is turned on.

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TurnDoubleStrikeModeOnOff(int n);
    
    /**
     * Print and feed paper (ESC J). Prints the data in the print buffer and feeds the paper n × (vertical or horizontal motion unit).

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintAndFeedPaper(int n);
    
    /**
     * Print and reverse feed (ESC K). Prints the data in the print buffer and feeds the paper n × (vertical motion unit) in the reverse direction.

     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintAndReverseFeed(int n);
    
    /**
     * Select character font (ESC M). Selects a character font, using n as follows:
           <br>n Font
           <br>0, 48 Font A
           <br>1, 49 Font B
           <br>2,50 Font C
           <br>97 Extended font
           * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectCharacterFont(int n);
    
    /**
     * Select an international character set (ESC R). Selects an international character set n as follows:
            <br>n Country
            <br>0 U.S.A.
            <br>1 France
            <br>2 Germany
            <br>3 U.K.
            <br>4 Denmark I
            <br>5 Sweden
            <br>6 Italy
            <br>7 Spain
            <br>8 Japan
            <br>9 Norway
            <br>10 Denmark II
            <br>11 Spain II
            <br>12 Latin America
            <br>13 Korean
            <br>14 Slovenia / Croatia
            <br>15 Chinese
           * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectInternationalCharacterSet(int n);
    
    /**
     * Turn unidirectional print mode on/off (ESC U). Turns unidirectional print mode on or off.
        <br>• When the LSB of n is 0, unidirectional print mode is turned off.
        <br>• When the LSB of n is 1, unidirectional print mode is turned on.
           * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TurnUnidirectionalPrintModeOnOff(int n);
    
    /**
     * Select justification (ESC a). In standard mode, aligns all the data in one line to the selected layout, using n as follows:
        <br>n Justification
        <br>0, 48 Left justification
        <br>1, 49 Centered
        <br>2, 50 Right justification
           * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectJustification(int n);
    
    /**
     * Select paper sensor(s) to output paper-end signals (ESC c 3). Selects the paper sensor(s) to output paper end signals when a paper end is detected using n as follows:
            <br>n:Bit Off/On Hex Decimal Function
            <br>0 Off 00 0 Roll paper near-end sensor disabled.
            <br>0 On 01 1 Roll paper near-end sensor enabled.
            <br>1 Off 00 0 Roll paper near-end sensor disabled.
            <br>1 On 02 2 Roll paper near-end sensor enabled.
            <br>2 Off 00 0 Roll paper end sensor disabled.
            <br>2 On 02 4 Roll paper end sensor enabled.
            <br>3 Off 00 0 Roll paper end sensor disabled.
            <br>3 On 08 8 Roll paper end sensor enabled.
            <br>4-7 — — — Undefined.
* 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectPaperSensorToOutputPaperEndSignals(int n);
    
    /**
     * Select paper sensor(s) to stop printing (ESC c 4). Selects the paper sensor(s) to use to stop printing when a paper end is detected using n as follows:
            <br>n: Bit Off/On Hex Decimal Function
            <br>0 Off 00 0 Roll paper near-end sensor disabled.
            <br>0 On 01 1 Roll paper near-end sensor enabled.
            <br>1 Off 00 0 Roll paper near-end sensor disabled.
            <br>1 On 02 2 Roll paper near-end sensor enabled.
            <br>2 Off 00 0 Roll paper end sensor disabled.
            <br>2 On 02 4 Roll paper end sensor enabled.
            <br>3 Off 00 0 Roll paper end sensor disabled.
            <br>3 On 08 8 Roll paper end sensor enabled.
            <br>4-7 — — — Undefined.
* 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectPaperSensorToStopPrinting(int n);
    
    /**
     * Enable/disable panel buttons (ESC c 5). Enables or disables the panel buttons.
            <br>• When the LSB of n is 0, all buttons are enabled.
            <br>• When the LSB of n is 1, all buttons are disabled.
* 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_EnableDisablePanelButtons(int n);
    
    /**
     * Print and feed n lines (ESC d). Prints the data in the print buffer and feeds n lines.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintAndFeedNLines(int n);
    
    /**
     * Print and reverse feed n lines (ESC e). Prints the data in the print buffer and feeds n lines.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintAndReverseFeedNLines(int n);
    
    /**
     * Partial cut (one point left uncut) (ESC i). Executes a partial cut of the roll paper.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PartialCutOnePointLeftUncut(int n);
    
    /**
     * Partial cut (three points left uncut) (ESC m). Executes a partial cut of the roll paper.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PartialCutThreePointsLeftUncut(int n);
    
    /**
     * Generate pulse (ESC p). Outputs the pulse specified by t1 and t2 to the specified connector pin m as follows:
            <br>m Connector pin
            <br>0, 48 Drawer kick-out connector pin 2
            <br>1, 49 Drawer kick-out connector pin 5
            <br>•The pulse for ON time is (t1 × 2 msec) and for OFF time is (t2 × 2 msec).
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_GeneratePulse(int n);
    
    /**
     * Select print color (ESC r). Selects a print color, using n as follows:
            <br>n Print color
            <br>0, 48 Black
            <br>1, 49 Red
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectPrintColor(int n);
    
    /**
     * Select character code table (ESC t). Selects a page n from the character code table as follows:
            <br>n Character code table
            <br>0 Page 0 [PC437 (U.S.A., Standard Europe)]
            <br>1 Page 1 [Katakana]
            <br>2 Page 2 [PC850 (Multilingual)]
            <br>3 Page 3 [PC860 (Portuguese)]
            <br>4 Page 4 [PC863 (Canadian-French)]
            <br>5 Page 5 [PC865 (Nordic)]
            <br>6 Page 6 [Simplified Kanji, Hirakana]
            <br>7 Page 7 [Simplified Kanji]
            <br>8 Page 8 [Simplified Kanji]
            <br>16 Page 16 [WPC1252]
            <br>17 Page 17 [PC866 (Cyrillic #2)]
            <br>18 Page 18 [PC852 (Latin 2)]
            <br>19 Page 19 [PC858 (Euro)]
            <br>254 Page 254
            <br>255 Page 255
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectCharacterCodeTable(int n);
    
    /**
     * Transmit peripheral device status (ESC u). Transmits the peripheral device status as 1 byte of data
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TransmitPeripheralDeviceStatus(int n);
    
    /**
     * Transmit paper sensor status (ESC v). Transmits the status of paper sensor(s) as 1 byte of data.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TransmitPaperSensorStatus(int n);
    
    /**
     * Turn upside-down print mode on/off (ESC {). In standard mode, turns upside-down print mode on or off.
            <br>• When the LSB of n is 0, upside-down print mode is turned off.
            <br>• When the LSB of n is 1, upside-down print mode is turned on.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TurnUpsideDownPrintModeOnOff(int n);
    
    /**
     * Print NV bit image (FS p). Prints NV bit image n using the process of FS q and using the mode specified by m.
            <br>m Mode ScalingHorizontal ScalingVertical
            <br>0, 48 Normal × 1 × 1
            <br>1, 49 Double-width × 2 × 1
            <br>2, 50 Double-height × 1 × 2
            <br>3, 51 Quadruple × 2 × 2
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_PrintNVBitImage(int n);
    
    /**
     * Set graphics data (GS ( L GS 8 L). Processes graphics data.
        <br>•Function code (fn) specifies the function.
        <br>fn  Function No.  Function name
        <br>0, 48 Function 48 Transmit the NV graphics memory capacity.
        <br>1, 49 Function 49 Set the reference standard dot density for graphics.
        <br>2, 50 Function 50 Print the graphics data in the print buffer.
        <br>3, 51 Function 51 Transmit the remaining capacity of the NV graphics memory.
        <br>4, 52 Function 52 Transmit the remaining capacity of the download graphics memory.
        <br>64 Function 64 Transmit the key code list for defined NV graphics.
        <br>65 Function 65 Delete all NV graphics data.
        <br>66 Function 66 Delete the specified NV graphics data.
        <br>67 Function 67 Define the NV graphics data (raster format).
        <br>68 Function 68 Define the NV graphics data (column format).
        <br>69 Function 69 Print the specified NV graphics data.
        <br>80 Function 80 Transmit the key code list for defined download graphics.
        <br>81 Function 81 Delete all NV graphics data.
        <br>82 Function 82 Delete the specified download graphics data.
        <br>83 Function 83 Define the downloaded graphics data (raster format).
        <br>84 Function 84 Define the downloaded graphics data (column format).
        <br>85 Function 85 Print the specified download graphics data.
        <br>112 Function 112 Store the graphics data in the print buffer (raster format).
        <br>113 Function 113 Store the graphics data in the print buffer (column format).
        <br>• p L , p H specifies (p L + p H × 256) as the number of bytes after p H (m, fn, and [parameters]).
        <br>• p1, p2, p3, and p4 specify (p1 + p2 × 256 + p3 × 65536 + p4 × 16777216) as the number of bytes after
          p H (m, fn, and [parameters]).
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SetGraphicsData(int n);
    
    /**
     * Execute test print (GS ( A). Executes a specified test print.
         <br>• p L , p H specifies (p L + p H × 256) as the number of bytes after p H (n and m).
         <br>• n specifies the paper used for the test print as follows:
         <br>   n Paper
         <br>   0, 48 Basic sheet (roll paper)
         <br>   1, 49
         <br>   2, 50 Roll paper
         <br>•m specifies a test pattern as follows:
         <br>   m Test pattern
         <br>   1, 49 Hexadecimal dump
         <br>   2, 50 Printer status printing
         <br>   3, 51 Rolling pattern
         <br>   64 Automatic setting of paper layout
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_ExecuteTestPrint(int n);
    
    /**
     * Edit NV user memory (GS ( C). Edits the data in the NV user memory.
            <br>•Function code fn specifies the function.
            <br>fn Function No. Function name
            <br>0, 48 Function 0 Delete the specified record
            <br>1, 49 Function 1 Store the data in the specified record
            <br>2, 50 Function 2 Transmit the data in the specified record
            <br>3, 51 Function 3 Transmit capacity of the NV user memory currently being used
            <br>4, 52 Function 4 Transmit the remaining capacity of the NV user memory
            <br>5, 53 Function 5 Transmit the key code list
            <br>6, 54 Function 6 Delete all data in the NV user memory
            <br>• p L , p H specifies (p L + p H × 256) as the number of bytes after p H (m, fn, b, [c1 c2], and [d1...dk]).
            <br>• The other parameters are explained under each of the functions.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_EditNVUserMemory(int n);
    
    /**
     * Enable/disable real-time command (GS ( D). Enables or disables the real-time command.
        <br>• p L , p H specifies (p L + p H × 256) as the number of bytes after p H (m and [a1 b1]...[ak bk]).
        <br>• a specifies the type of real-time command.
        <br>• b specifies enable/disable of real-time command processing.
        <br>a b Function
        <br>1 0, 48 Disable DLE DC4 fn m t (fn = 1) (does not execute the process)
          <br>1, 49 Enable DLE DC4 fn m t (fn = 1) (executes the process)
        <br>2 0, 48 Disable DLE DC4 fn m t (fn = 2) (does not execute the process)
          <br>1, 49 Enable DLE DC4 fn m t (fn = 2) (executes the process)
        <br>• a specifies the type of real-time command.
        <br>• b specifies enable/disable of real-time command processing.
        <br>a b Real-time command type
        <br>1 0, 48 Disable DLE DC4 n m t (n = 1): (does not execute the process)
          <br>1, 49 Enable DLE DC4 n m t (n = 1): (execute the process)
        <br>2 0, 48 Disable DLE DC4 n a b (n = 2): (does not execute the process)
          <br>1, 49 Enable DLE DC4 n a b (n = 2): (execute the process)
        <br>DLE DC4 n m t (n=1): Generate pulse in real-time.
        <br>DLE DC4 n a b (n=2): Execute power-off sequence.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_EnableDisableRealTimeCommand(int n);
    
    /**
     * Set user setup commands (GS ( E). Controls the user setting modes. The table below explains the functions available in this command.
        <br>•Function code fn specifies the function.
        <br>fn Function No. Function name
        <br>1 Function 1 Change into the user setting mode.
        <br>2 Function 2 End the user setting mode session.
        <br>3 Function 3 Change the memory switch.
        <br>4 Function 4 Transmit the settings of the memory switch.
        <br>5 Function 5 Set the customized setting values.
        <br>6 Function 6 Transmit the customized setting values.
        <br>7 Function 7 Copy the user-defined page.
        <br>8 Function 8 Define the data (column format) for the character code page.
        <br>9 Function 9 Define the data (raster format) for the character code page.
        <br>10 Function 10 Delete the data for the character code page.
        <br>11 Function 11 Set the communication item for the serial interface.
        <br>12 Function 12 Transmit the communication item for the serial interface.
        <br>13 Function 13 Set the configuration item for the Bluetooth interface.
        <br>14 Function 14 Transmit the configuration item for the Bluetooth interface.
        <br>48 Function 48 Delete the paper layout
        <br>49 Function 49 Set the paper layout
        <br>50 Function 50 Transmit the paper layout information
        <br>•p L , p H specifies (p L + p H × 256) as the number of bytes after p H (fn and [parameters]).
        <br>Description of the [parameters] is described in each function.
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SetUserSetupCommands(int n);
    
    /**
     * Transmit printer ID (GS I). Transmits the printer ID or printer information.
        <br>•Transmits 1 byte of printer ID, using n as follows:
        <br>    n Printer ID Specification
        <br>    1, 49 Printer model ID Printer model
        <br>    2, 50 Type ID Printer type
        <br>    3, 51 Version ID Firmware version
        <br> •Transmits specified printer information A, using n as follows:
        <br>    n Printer ID Specification
        <br>    33 Type information Supported functions
        <br>    96, 110 See [Printer information] See [Printer information]
        <br>•Transmits specified printer information B, using n as follows:
        <br>n Printer ID Specification
        <br>65 Firmware version Firmware version
        <br>66 Maker name “EPSON”
        <br>67 Printer model Printer model
        <br>68 Serial No Serial No of the printer
        <br>69 Font of Language for each country Japanese: “KANJI JAPANESE”
          <br> Simplified Chinese: “CHINA GB2312” or “CHINA GB18030”
           <br>Traditional Chinese: “TAIWAN BIG-5”
        <br>112 See model-dependent variations See model-dependent variations
     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TransmitPrinterID(int n);
  
    /**
     * Select cut mode and cut paper (GS V). Executes paper cutting specified by m, as follows:
        <br>m Function
        <br>A>  0, 48 Executes a full cut (cuts the paper completely).
        <br>    1, 49 Executes a partial cut (one point left uncut).
        <br>B>  65 Feeds paper to (cutting position + n × vertical motion unit) and executes a full cut (cuts
        <br>    the paper completely).
        <br>    66 Feeds paper to (cutting position + n × vertical motion unit) and executes a partial cut
        <br>    (one point left uncut).
        <br>C>  97 Specifies a paper cutting range to (basic paper feed amount + [n × vertical motion unit]
        <br>    and executes a full cut.
        <br>    98 Specifies a paper cutting range to (basic paper feed amount + [n × vertical motion unit]
        <br>    and executes a partial cut (one point left uncut).
        <br>D>  103 Feeds paper to (cutting position + n × vertical motion unit) and executes a full cut (cuts
        <br>    the paper completely), then feeds paper to the print start position.
        <br>    104 Feeds paper to (cutting position + n × vertical motion unit) and executes a partial cut
        <br>    (one point left uncut), then feeds paper to the print start position.
        <br>• n of B> and D> specify paper feed amount executed immediately before a paper cut.
        <br>• n of C> specifies a range of paper cut.

     * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_SelectCutModeAndCutPaper(byte n);
    
    /**
     * Enable/disable Automatic Status Back ASB (GS a). Enables or disables basic ASB (Automatic Status Back) and specifies the status items to include, using n as follows:
        <br>n:Bit Binary Hex Decimal Function
        <br>0 0 0 00 0 Drawer kick-out connector status disabled.
        <br>  1 01 1 Drawer kick-out connector status enabled.
        <br>1 0 00 0 Online/offline status disabled.
        <br>  1 02 2 Online/offline status enabled.
        <br>2 0 00 0 Error status disabled.
        <br>  1 04 4 Error status enabled.
        <br>3 0 00 0 Roll paper sensor status disabled.
        <br>  1 08 8 Roll paper sensor status enabled.
        <br>4 0 00 0 Undefined.
        <br>5 0 00 0 Undefined. 
        <br>6 0 00 0 Panel switch status disabled.
        <br>  1 40 64 Panel switch status enabled.
        <br>7 0 00 0 Undefined.
 * 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_EnableDisableAutomaticStatusBackASB(int n);
    
    /**
     * Transmit status (GS r).Transmits the status using n as follows:
        <br>n Function
        <br>1, 49 Transmits paper sensor status
        <br>2, 50 Transmits drawer kick-out connector status
        <br>4, 52 Transmits ink status
 
     * @return  Regresa el comando {@code byte[]} que ejecuta la secuencia.
     */
    public byte[] cmd_TransmitStatus(int n);

    
    
}
