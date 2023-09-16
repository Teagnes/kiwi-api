// Generated from /Users/nerv/IdeaProjects/kiwi-api/src/main/resources/SASLog.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SASLogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SASLogVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SASLogParser#saslog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaslog(SASLogParser.SaslogContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SASLogParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(SASLogParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#info}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInfo(SASLogParser.InfoContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#warning}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWarning(SASLogParser.WarningContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#error}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitError(SASLogParser.ErrorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#source}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource(SASLogParser.SourceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#source2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSource2(SASLogParser.Source2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#mprint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMprint(SASLogParser.MprintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#garbage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGarbage(SASLogParser.GarbageContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#pageBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPageBreak(SASLogParser.PageBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link SASLogParser#emptyLine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyLine(SASLogParser.EmptyLineContext ctx);
}