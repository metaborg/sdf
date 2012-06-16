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

@SuppressWarnings("all") final class lifted137 extends Strategy 
{ 
  public static final lifted137 instance = new lifted137();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail856:
    { 
      IStrategoTerm d_9724 = null;
      IStrategoTerm e_9724 = null;
      IStrategoTerm f_9724 = null;
      IStrategoTerm g_9724 = null;
      IStrategoTerm h_9724 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail856;
      d_9724 = ((IStrategoList)term).head();
      e_9724 = ((IStrategoList)term).tail();
      IStrategoList annos4 = term.getAnnotations();
      h_9724 = annos4;
      term = $String_1_0.instance.invoke(context, d_9724, lifted138.instance);
      if(term == null)
        break Fail856;
      f_9724 = term;
      term = e_9724;
      g_9724 = e_9724;
      IStrategoList list6;
      list6 = checkListTail(g_9724);
      if(list6 == null)
        break Fail856;
      term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(f_9724, list6), checkListAnnos(termFactory, h_9724));
      if(true)
        return term;
    }
    return null;
  }
}