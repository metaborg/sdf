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

@SuppressWarnings("all") final class lifted393 extends Strategy 
{ 
  TermReference x_32984;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1629:
    { 
      IStrategoTerm y_32984 = null;
      IStrategoTerm z_32984 = null;
      IStrategoTerm a_32985 = null;
      IStrategoTerm b_32985 = null;
      IStrategoTerm c_32985 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1629;
      y_32984 = ((IStrategoList)term).head();
      z_32984 = ((IStrategoList)term).tail();
      IStrategoList annos30 = term.getAnnotations();
      c_32985 = annos30;
      term = y_32984;
      lifted394 lifted3940 = new lifted394();
      lifted3940.x_32984 = x_32984;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, term, lifted3940);
      if(term == null)
        break Fail1629;
      a_32985 = term;
      term = z_32984;
      b_32985 = z_32984;
      IStrategoList list28;
      list28 = checkListTail(b_32985);
      if(list28 == null)
        break Fail1629;
      term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(a_32985, list28), checkListAnnos(termFactory, c_32985));
      if(true)
        return term;
    }
    return null;
  }
}