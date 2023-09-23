// Generated from /Users/nerv/IdeaProjects/kiwi-api/src/main/resources/SASLog.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SASLogParser}.
 */
public interface SASLogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SASLogParser#saslog}.
	 * @param ctx the parse tree
	 */
	void enterSaslog(SASLogParser.SaslogContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#saslog}.
	 * @param ctx the parse tree
	 */
	void exitSaslog(SASLogParser.SaslogContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SASLogParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SASLogParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(SASLogParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(SASLogParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#info}.
	 * @param ctx the parse tree
	 */
	void enterInfo(SASLogParser.InfoContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#info}.
	 * @param ctx the parse tree
	 */
	void exitInfo(SASLogParser.InfoContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#warning}.
	 * @param ctx the parse tree
	 */
	void enterWarning(SASLogParser.WarningContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#warning}.
	 * @param ctx the parse tree
	 */
	void exitWarning(SASLogParser.WarningContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#error}.
	 * @param ctx the parse tree
	 */
	void enterError(SASLogParser.ErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#error}.
	 * @param ctx the parse tree
	 */
	void exitError(SASLogParser.ErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#source}.
	 * @param ctx the parse tree
	 */
	void enterSource(SASLogParser.SourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#source}.
	 * @param ctx the parse tree
	 */
	void exitSource(SASLogParser.SourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#source2}.
	 * @param ctx the parse tree
	 */
	void enterSource2(SASLogParser.Source2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#source2}.
	 * @param ctx the parse tree
	 */
	void exitSource2(SASLogParser.Source2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#mprint}.
	 * @param ctx the parse tree
	 */
	void enterMprint(SASLogParser.MprintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#mprint}.
	 * @param ctx the parse tree
	 */
	void exitMprint(SASLogParser.MprintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#garbage}.
	 * @param ctx the parse tree
	 */
	void enterGarbage(SASLogParser.GarbageContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#garbage}.
	 * @param ctx the parse tree
	 */
	void exitGarbage(SASLogParser.GarbageContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#pageBreak}.
	 * @param ctx the parse tree
	 */
	void enterPageBreak(SASLogParser.PageBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#pageBreak}.
	 * @param ctx the parse tree
	 */
	void exitPageBreak(SASLogParser.PageBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link SASLogParser#emptyLine}.
	 * @param ctx the parse tree
	 */
	void enterEmptyLine(SASLogParser.EmptyLineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SASLogParser#emptyLine}.
	 * @param ctx the parse tree
	 */
	void exitEmptyLine(SASLogParser.EmptyLineContext ctx);
}