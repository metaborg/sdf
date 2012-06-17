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

@SuppressWarnings("all") public class $Template$Section_1_0 extends Strategy 
{ 
  public static $Template$Section_1_0 instance = new $Template$Section_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TemplateSection_1_0");
    Fail1358:
    { 
      IStrategoTerm q_32978 = null;
      IStrategoTerm p_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1358;
      p_32978 = term.getSubterm(0);
      IStrategoList annos123 = term.getAnnotations();
      q_32978 = annos123;
      term = j_32795.invoke(context, p_32978);
      if(term == null)
        break Fail1358;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplateSection_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}