package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Indent$Defs_1_0 extends Strategy 
{ 
  public static $Indent$Defs_1_0 instance = new $Indent$Defs_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("IndentDefs_1_0");
    Fail1285:
    { 
      IStrategoTerm x_32967 = null;
      IStrategoTerm w_32967 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consIndentDefs_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1285;
      w_32967 = term.getSubterm(0);
      IStrategoList annos56 = term.getAnnotations();
      x_32967 = annos56;
      term = h_32791.invoke(context, w_32967);
      if(term == null)
        break Fail1285;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consIndentDefs_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, x_32967));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}