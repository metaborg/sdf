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

@SuppressWarnings("all") public class $Language$Name_1_0 extends Strategy 
{ 
  public static $Language$Name_1_0 instance = new $Language$Name_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("LanguageName_1_0");
    Fail1299:
    { 
      IStrategoTerm n_32969 = null;
      IStrategoTerm m_32969 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLanguageName_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1299;
      m_32969 = term.getSubterm(0);
      IStrategoList annos70 = term.getAnnotations();
      n_32969 = annos70;
      term = v_32791.invoke(context, m_32969);
      if(term == null)
        break Fail1299;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLanguageName_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}