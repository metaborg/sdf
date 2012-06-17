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

@SuppressWarnings("all") public class $Placeholder$With$Sort_2_0 extends Strategy 
{ 
  public static $Placeholder$With$Sort_2_0 instance = new $Placeholder$With$Sort_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_32789, Strategy x_32789)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("PlaceholderWithSort_2_0");
    Fail1247:
    { 
      IStrategoTerm i_32964 = null;
      IStrategoTerm g_32964 = null;
      IStrategoTerm h_32964 = null;
      IStrategoTerm j_32964 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholderWithSort_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1247;
      g_32964 = term.getSubterm(0);
      h_32964 = term.getSubterm(1);
      IStrategoList annos36 = term.getAnnotations();
      i_32964 = annos36;
      term = w_32789.invoke(context, g_32964);
      if(term == null)
        break Fail1247;
      j_32964 = term;
      term = x_32789.invoke(context, h_32964);
      if(term == null)
        break Fail1247;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{j_32964, term}), checkListAnnos(termFactory, i_32964));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}