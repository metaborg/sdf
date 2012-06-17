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

@SuppressWarnings("all") public class $Indent$Def_1_0 extends Strategy 
{ 
  public static $Indent$Def_1_0 instance = new $Indent$Def_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("IndentDef_1_0");
    Fail1280:
    { 
      IStrategoTerm f_32967 = null;
      IStrategoTerm e_32967 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consIndentDef_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1280;
      e_32967 = term.getSubterm(0);
      IStrategoList annos52 = term.getAnnotations();
      f_32967 = annos52;
      term = a_32791.invoke(context, e_32967);
      if(term == null)
        break Fail1280;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consIndentDef_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, f_32967));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}